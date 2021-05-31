package com.timing.feedback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.vo.UserOpinionsCountVO;

/**
 * <p>
 * 只记录未处理意见 Mapper 接口
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
public interface UserOpinionsCountMapper extends BaseMapper<UserOpinionsCount> {
    /**
    * 返回用户count排序
    * @param page 分页
    * @return: List<UserOpinionsCountBO>
    **/
    IPage<UserOpinionsCountVO> listUserCount(IPage<UserOpinionsCountVO> page);

    /**
    * 用户count+1
    * @param id
    * @return: List<UserOpinionsCountBO>
    **/
    int addUserCount(int id);

    /**
    * 用户count-1
    * @param id
    * @return: List<UserOpinionsCountBO>
    **/
    int deductUserCount(int id);
}
