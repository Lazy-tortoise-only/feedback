package com.timing.feedback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timing.feedback.bo.OpinionsReplyBO;
import com.timing.feedback.entity.OpinionsReply;
import com.timing.feedback.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
public interface OpinionsReplyService extends IService<OpinionsReply> {


    /**
     * 回复消息
     *
     * @param opinionsReply 回复消息
     * @return:
     **/
    ResultVO replyOpinions(OpinionsReplyBO opinionsReply);

}