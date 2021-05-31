package com.timing.feedback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.timing.feedback.entity.Opinions;
import com.timing.feedback.vo.OpinionsVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
public interface OpinionsMapper extends BaseMapper<Opinions> {
    /**
    * 按userId分页查询用户反馈问题
    * @param userId 用户id
     * @param page 分页
    * @return: IPage<OpinionsVO>
    **/
    IPage<OpinionsVO> listOpinions(IPage<OpinionsVO> page,int userId);
}
