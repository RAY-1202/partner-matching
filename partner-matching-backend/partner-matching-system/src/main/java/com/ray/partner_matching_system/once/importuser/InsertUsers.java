package com.ray.partner_matching_system.once.importuser;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.ray.partner_matching_system.mapper.UserMapper;
import com.ray.partner_matching_system.model.domain.User;

import javax.annotation.Resource;

/**
 * 导入用户任务
 */
@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("goodgoodgood");
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("user_" + i);
            user.setUserAccount("fakeAccount" + i);
            user.setAvatarUrl("https://cdn-icons-png.flaticon.com/128/18775/18775901.png");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
