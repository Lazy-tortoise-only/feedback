package com.timing.feedback.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.timing.feedback.entity.Opinions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class OpinionsBO {

    /**
     * id唯一标识
     */
    private Integer id;

    /**
     * 反馈意见用户id
     */
    @NotNull
    private Integer userId;


    /**
     * 反馈类型
     */
    @NotNull
    @Max(value = 5,message = "反馈类型格式错误")
    @Min(value = 0,message = "反馈类型格式错误")
    private Integer opinionsType;

    /**
     * 反馈内容
     */
    @NotNull
    @Size(min = 10,max = 300,message = "反馈内容格式错误")
    private String opinionsContent;

    /**
     * 联系方式
     */
    private String opinionsContact;

    /**
     * 是否处理
     */
    @Max(value = 1,message = "反馈类型格式错误")
    @Min(value = 0,message = "反馈类型格式错误")
    private Integer state;

    public Opinions translate(){
        return  new Opinions(id,userId,opinionsType,opinionsContent,opinionsContact,state);
    }

}
