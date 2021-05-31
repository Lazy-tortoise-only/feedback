package com.timing.feedback.bo;

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
public class CustomerServiceBO {

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

    /**
     * 客服昵称
     */
    private String nickname;



}
