package com.ray.partner_matching_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ray.partner_matching_system.mapper.UserTeamMapper;
import com.ray.partner_matching_system.model.domain.UserTeam;
import com.ray.partner_matching_system.service.UserTeamService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 用户队伍服务实现类
 */
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
        implements UserTeamService {

    // 添加对空列表的检查
    public List<UserTeam> listByTeamIds(List<Long> teamIds) {
        // 如果teamIds为空，直接返回空列表，避免SQL语法错误
        if (teamIds == null || teamIds.isEmpty()) {
            return new ArrayList<>();
        }
        QueryWrapper<UserTeam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDelete", 0);
        queryWrapper.in("teamId", teamIds);
        return this.list(queryWrapper);
    }
}




