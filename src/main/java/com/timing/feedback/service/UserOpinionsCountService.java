package com.timing.feedback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.vo.ResultVO;

/**
 * <p>
 * 只记录未处理意见 服务类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
public interface UserOpinionsCountService extends IService<UserOpinionsCount> {
    /**
    * 返回用户回复列表
     * @param current 页数
     * @param size 每页多少条
    * @return: List<UserOpinionsCountBO>
    **/
    ResultVO listUserCount(int current, int size);
}
