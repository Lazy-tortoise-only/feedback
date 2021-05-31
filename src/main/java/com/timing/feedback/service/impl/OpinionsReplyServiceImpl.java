package com.timing.feedback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timing.feedback.bo.OpinionsReplyBO;
import com.timing.feedback.entity.CustomerService;
import com.timing.feedback.entity.Opinions;
import com.timing.feedback.entity.OpinionsReply;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.mapper.CustomerServiceMapper;
import com.timing.feedback.mapper.OpinionsMapper;
import com.timing.feedback.mapper.OpinionsReplyMapper;
import com.timing.feedback.mapper.UserOpinionsCountMapper;
import com.timing.feedback.service.OpinionsReplyService;
import com.timing.feedback.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Service
public class OpinionsReplyServiceImpl extends ServiceImpl<OpinionsReplyMapper, OpinionsReply> implements OpinionsReplyService {
    @Resource
    private OpinionsReplyMapper opinionsReplyMapper;

    @Resource
    private CustomerServiceMapper customerServiceMapper;

    @Resource
    private OpinionsMapper opinionsMapper;

    @Resource
    private UserOpinionsCountMapper userOpinionsCountMapper;

    @Override
    public ResultVO replyOpinions(OpinionsReplyBO opinionsReplyBo) {
        //BO转换为POJO
        OpinionsReply opinionsReply = opinionsReplyBo.translate();

        //查询反馈问题是否已经操作
        Opinions opinions = opinionsMapper.selectById(opinionsReply.getOpinionsId());
        //反馈state为1，说明此反馈问题已经处理
        if (opinions.getState() == 1){
           return ResultVO.error().message("此反馈已处理");
        }

        //state是1，是关闭会话
        if (opinionsReplyBo.getState() == 1){
            //查询客服名字
            CustomerService customerService = customerServiceMapper.selectById(opinionsReplyBo.getCustomerServiceId());
            opinionsReply.setReplyClose("客服"+customerService.getNickname()+"关闭了该条会话");

        }
        //根据用户id查询count
        UserOpinionsCount userOpinionsCount = userOpinionsCountMapper.selectOne(new QueryWrapper<UserOpinionsCount>().lambda().eq(UserOpinionsCount::getUserId,
            opinions.getUserId()));
        //如果查询对象不为空且count>0，count-1
        if (userOpinionsCount != null && userOpinionsCount.getCount() > 0){
            userOpinionsCountMapper.deductUserCount(userOpinionsCount.getId());
        }
        //插入记录
        int insert = opinionsReplyMapper.insert(opinionsReply);
        //修改反馈问题表state
        opinionsMapper.updateById(new Opinions(opinionsReply.getOpinionsId(),1));
        return insert > 0 ? ResultVO.ok(): ResultVO.error();
    }
}
