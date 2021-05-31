package com.timing.feedback.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.mapper.UserOpinionsCountMapper;
import com.timing.feedback.service.UserOpinionsCountService;
import com.timing.feedback.vo.PageUserOpinionsCountVO;
import com.timing.feedback.vo.ResultVO;
import com.timing.feedback.vo.UserOpinionsCountVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 只记录未处理意见 服务实现类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Service
public class UserOpinionsCountServiceImpl extends ServiceImpl<UserOpinionsCountMapper, UserOpinionsCount> implements UserOpinionsCountService {

    @Resource
    private UserOpinionsCountMapper userOpinionsCountMapper;

    @Override
    public ResultVO listUserCount(int current, int size) {
        //分页,当前页和每页数量
        Page<UserOpinionsCountVO> page= new Page<>(current,size,true);
        IPage<UserOpinionsCountVO> listUserCount = userOpinionsCountMapper.listUserCount(page);
        return ResultVO.ok().data("listUserCount",new PageUserOpinionsCountVO(listUserCount.getRecords(),
            listUserCount.getCurrent(),listUserCount.getSize(),listUserCount.getPages()));
    }

}
