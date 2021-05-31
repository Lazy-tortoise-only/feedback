package com.timing.feedback.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.timing.feedback.entity.OpinionsReply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
public class OpinionsReplyBO{

    /**
     * 反馈id
     */
    @NotNull
    @Min(value = 0,message = "不能小于0")
    private Integer opinionsId;

    /**
     * 客服id
     */
    @NotNull
    @Min(value = 0,message = "不能小于0")
    private Integer customerServiceId;

    /**
     * 回复内容
     */
    private String replyContent;


    /**
     * 回复状态，0回复，1关闭
     */
    @Range(min = 0,max = 1)
    private Integer state;

    public OpinionsReply translate(){
        return new OpinionsReply(opinionsId,customerServiceId,replyContent,state);
    }

}
