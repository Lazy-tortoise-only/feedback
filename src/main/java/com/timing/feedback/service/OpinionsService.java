package com.timing.feedback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timing.feedback.bo.OpinionsBO;
import com.timing.feedback.entity.Opinions;
import com.timing.feedback.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
public interface OpinionsService extends IService<Opinions> {
    /**
    * 保存用户建议
    * @param opinionsBO
    * @return:
    **/
    ResultVO saveOpinionsAndCount(OpinionsBO opinionsBO);

    /**
     * 通过用户id，按时间倒序分页查询用户反馈意见
     *
     * @param current
     * @param size
     * @param userId
     * @return:
     **/
    ResultVO listOpinions(int current, int size, int userId);
}
