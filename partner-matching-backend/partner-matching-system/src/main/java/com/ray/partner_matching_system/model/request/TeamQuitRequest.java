package com.ray.partner_matching_system.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * id
     */
    private Long teamId;

}
