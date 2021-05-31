package com.timing.feedback.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Data
public class CustomerServiceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客服位移标识
     */
    private Integer id;

    /**
     * 客服用户名
     */
    private String username;

    /**
     * 客服密码
     */
    private String password;

    private Date createTime;

    private Date updateTime;

    /**
     * 客服昵称
     */
    private String nickname;


}
