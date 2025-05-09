package com.ray.partner_matching_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.partner_matching_system.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     */
    boolean isAdmin(User loginUser);

    /**
     * 匹配用户
     */
    List<User> matchUsers(long num, User loginUser);
}
