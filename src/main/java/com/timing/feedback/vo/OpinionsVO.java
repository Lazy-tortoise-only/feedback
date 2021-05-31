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
public class OpinionsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id唯一标识
     */
    private Integer id;

    /**
     * 反馈意见用户id
     */
    private Integer userId;

    /**
     * 用户昵称
     */
    private String nickname;

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
     * 回复
     */
    private OpinionsReplyVO opinionsReplyVO;

    /**
     * 0未处理，1回复，2关闭
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date createTime;

}
