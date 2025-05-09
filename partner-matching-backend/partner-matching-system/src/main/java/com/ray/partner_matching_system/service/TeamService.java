package com.ray.partner_matching_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ray.partner_matching_system.model.domain.Team;
import com.ray.partner_matching_system.model.domain.User;
import com.ray.partner_matching_system.model.dto.TeamQuery;
import com.ray.partner_matching_system.model.request.TeamJoinRequest;
import com.ray.partner_matching_system.model.request.TeamQuitRequest;
import com.ray.partner_matching_system.model.request.TeamUpdateRequest;
import com.ray.partner_matching_system.model.vo.TeamUserVO;

import java.util.List;

/**
 * 队伍服务
 */
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     */
    boolean deleteTeam(long id, User loginUser);
}
