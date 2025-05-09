<template>
  <div id="teamAddPage">
    <van-form @submit="onSubmit">
      <van-cell-group inset>
      <van-field
            v-model="addTeamData.name"
            name="name"
            label="队伍名"
            placeholder="请输入队伍名"
            :rules="[{ required: true, message: '请输入队伍名' }]"
        />
        <van-field
            v-model="addTeamData.description"
            rows="4"
            autosize
            label="队伍描述"
            type="textarea"
            placeholder="请输入队伍描述"
        />
        <van-field
            is-link
            readonly
            name="datetimePicker"
            label="过期时间"
            :placeholder="typeof addTeamData.expireTime === 'string' 
              ? addTeamData.expireTime 
              : (addTeamData.expireTime ? addTeamData.expireTime.toLocaleString() : '点击选择过期时间')"
            @click="showPicker = true"
        />
        <van-popup v-model:show="showPicker" position="bottom">
          <van-date-picker
              v-model="addTeamData.expireTime"
              @confirm="(values) => {
                showPicker = false;
                addTeamData.expireTime = values;
              }"
              type="datetime"
              title="请选择过期时间"
              :min-date="minDate"
          />
        </van-popup>
        <van-field name="radio" label="队伍状态">
          <template #input>
            <van-radio-group v-model="addTeamData.status" direction="horizontal">
              <van-radio name="0">公开</van-radio>
              <van-radio name="1">私有</van-radio>
              <van-radio name="2">加密</van-radio>
            </van-radio-group>
          </template>
        </van-field>
        <van-field
            v-if="Number(addTeamData.status) === 2"
            v-model="addTeamData.password"
            type="password"
            name="password"
            label="密码"
            placeholder="请输入队伍密码"
            :rules="[{ required: true, message: '请填写密码' }]"
        />
      </van-cell-group>
      <div style="margin: 16px;">
        <van-button round block type="primary" native-type="submit">
          提交
        </van-button>
      </div>
    </van-form>
  </div>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios";
import {showToast} from "vant";
import type {TeamType} from "../models/team";
import 'vant/es/date-picker/style';

const router = useRouter();
const route = useRoute();

// 展示日期选择器
const showPicker = ref(false);

const minDate = new Date();

const id = route.query.id;

// 需要用户填写的表单数据
const addTeamData = ref<Partial<TeamType>>({
  name: '',
  description: '',
  expireTime: [new Date().toISOString()], // 改为字符串数组
  status: 0,
});

// 获取之前的队伍信息
onMounted(async () => {
  if (!id || Number(id) <= 0) {
    showToast('加载队伍失败');
    return;
  }
  const res = await myAxios.get("/team/get", {
    params: {
      id,
    }
  });
  if (res?.data?.code === 0) {
    const data = res.data;
    // 确保 expireTime 是 Date 类型
    if (typeof data.expireTime === 'string') {
      data.expireTime = new Date(data.expireTime);
    }
    addTeamData.value = data;
  } else {
    showToast('加载队伍失败，请刷新重试');
  }
})

// 提交
const onSubmit = async () => {
  const postData = {
    ...addTeamData.value,
    status: Number(addTeamData.value.status),
    expireTime: new Date(addTeamData.value.expireTime[0]), // 转换回Date
  }
  // todo 前端参数校验
  const res = await myAxios.post("/team/update", postData);
  if (res?.data?.code === 0 && res.data){
    showToast('更新成功');
    router.push({
      path: '/team',
      replace: true,
    });
  } else {
    showToast('更新失败');
  }
}
</script>

<style scoped>
#teamPage {

}
</style>
