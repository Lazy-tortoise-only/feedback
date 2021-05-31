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
 * 只记录未处理意见
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOpinionsCountBO {
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
     * 最后添加时间，用来排序
     */
    private Date lastAddTime;

    public UserOpinionsCountBO(Integer userId, Integer count, Date lastAddTime) {
        this.userId = userId;
        this.count = count;
        this.lastAddTime = lastAddTime;
    }
}
