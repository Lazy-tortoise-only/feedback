package com.timing.feedback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
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
@EqualsAndHashCode(callSuper = false)
@TableName("opinions")
public class Opinions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id唯一标识
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 反馈意见用户id
     */
    @NotNull
    @Min(value = 0,message = "id不能为0")
    private Integer userId;

    /**
     * 反馈类型
     */
    private Integer opinionsType;

    /**
     * 反馈内容
     */
    private String opinionsContent;

    /**
     * 联系方式
     */
    private String opinionsContact;

    /**
     * 是否处理
     */
    private Integer state;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


    public Opinions(Integer id, Integer userId, Integer opinionsType, String opinionsContent, String opinionsContact, Integer state) {
        this.id=id;
        this.userId=userId;
        this.opinionsType=opinionsType;
        this.opinionsContent=opinionsContent;
        this.opinionsContact=opinionsContact;
        this.state=state;
    }

    public Opinions(Integer id, int state) {
        this.id=id;
        this.state=state;
    }
}
