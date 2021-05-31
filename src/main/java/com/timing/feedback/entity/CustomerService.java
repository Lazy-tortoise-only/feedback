package com.timing.feedback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.locks.Lock;

/**
 * <p>
 * 
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("customer_service")
public class CustomerService implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客服位移标识
     */
    @TableId(value = "id", type = IdType.AUTO)
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


    public CustomerService(String username, String password, String nickname) {
        this.username=username;
        this.password=password;
        this.nickname=nickname;
    }
}
