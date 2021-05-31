package com.timing.feedback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
@EqualsAndHashCode(callSuper = false)
@TableName("opinions_reply")
public class OpinionsReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈回复唯一表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 反馈id
     */
    private Integer opinionsId;

    /**
     * 客服id
     */
    private Integer customerServiceId;

    /**
     * 回复内容
     */
    private String replyContent;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 关闭会话内容
     */
    private String replyClose;

    /**
     * 回复状态，0回复，1关闭
     */
    private Integer state;

    public OpinionsReply(Integer opinionsId, Integer customerServiceId, String replyContent, Integer state) {
        this.opinionsId=opinionsId;
        this.customerServiceId=customerServiceId;
        this.replyContent=replyContent;
        this.state=state;
    }
}
