package com.timing.feedback.vo;

import com.timing.feedback.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 只记录未处理意见
 * </p>
 *
 * @author cwh1
 * @since 2021-05-27
 */
@Data
public class UserOpinionsCountVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户反馈回复记录表唯一标识
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 未处理意见数
     */
    private Integer count;

    /**
     * 用户
     */
    private String nickname;


}
