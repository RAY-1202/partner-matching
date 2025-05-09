<template>
  <user-card-list :user-list="userList" :loading="loading" />
  <van-empty v-if="!userList || userList.length < 1" description="搜索结果为空" />
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {useRoute} from "vue-router";
import myAxios from "../plugins/myAxios";
import {showToast} from "vant";
import qs from 'qs';
import UserCardList from "../components/UserCardList.vue";
import type {UserType} from "../models/user";

const route = useRoute();
const {tags} = route.query;

const loading = ref<boolean>(false);
const userList = ref<UserType[]>([]);

onMounted(async () => {
  loading.value = true;
  try {
    const userListData = await myAxios.get('/user/search/tags', {
      params: {
        tagNameList: tags
      },
      paramsSerializer: params => {
        return qs.stringify(params, {indices: false})
      }
    })
    .then(function (response) {
      return response?.data;
    })
    .catch(function (error) {
      console.error('/user/search/tags error', error);
      showToast('请求失败');
    });

    if (userListData) {
      userList.value = userListData.map((user: UserType) => ({
        ...user,
        tags: user.tags ? JSON.parse(user.tags) : []
      }));
    }
  } catch (error) {
    console.error('处理数据失败', error);
    showToast('处理数据失败');
  } finally {
    loading.value = false;
  }
});
</script>

<style scoped>

</style>
