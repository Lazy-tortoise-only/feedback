package com.timing.feedback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timing.feedback.bo.OpinionsBO;
import com.timing.feedback.entity.Opinions;
import com.timing.feedback.entity.User;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.mapper.OpinionsMapper;
import com.timing.feedback.mapper.UserMapper;
import com.timing.feedback.mapper.UserOpinionsCountMapper;
import com.timing.feedback.service.OpinionsService;
import com.timing.feedback.vo.OpinionsVO;
import com.timing.feedback.vo.PageOpinionsVO;
import com.timing.feedback.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Service
public class OpinionsServiceImpl extends ServiceImpl<OpinionsMapper, Opinions> implements OpinionsService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private OpinionsMapper opinionsMapper;

    @Resource
    private UserOpinionsCountMapper userOpinionsCountMapper;

    @Override
    public ResultVO saveOpinionsAndCount(OpinionsBO opinionsBO) {

        //将BO转化为POJO
        Opinions opinions = opinionsBO.translate();

        //插入数据
        int opinionInsert = opinionsMapper.insert(opinions);

        //判断是否插入成功,若插入成功，更新userOpinionsCount表
        if (opinionInsert <= 0){
            return ResultVO.error();
        }

        //查询此用户是否有记录，用userId查询
        LambdaQueryWrapper<UserOpinionsCount> wrapper = new QueryWrapper<UserOpinionsCount>().lambda();
        UserOpinionsCount userOpinionsCount =
            userOpinionsCountMapper.selectOne(wrapper.eq(UserOpinionsCount::getUserId,opinions.getUserId()));

        if (userOpinionsCount == null){
            //记录为空时，插入第一条记录
            int insertCount = userOpinionsCountMapper.insert(new UserOpinionsCount(opinions.getUserId(), 1,
                new Date()));
            //insertCount > 0说明插入成功
            return insertCount > 0 ? ResultVO.ok() : ResultVO.error();
        }else {
            //通过查询到的userOpinionsCount的id，修改数据
            int updateCount = userOpinionsCountMapper.addUserCount(userOpinionsCount.getId());
            //insertCount > 0 说明修改成功
            return updateCount > 0 ? ResultVO.ok() : ResultVO.error();
        }
    }


    @Override
    public ResultVO listOpinions(int current, int size, int userId) {
        Page<OpinionsVO> page= new Page<>(current,size);
        IPage<OpinionsVO> listOpinions = opinionsMapper.listOpinions(page, userId);

        return ResultVO.ok().data("listOpinions",new PageOpinionsVO(listOpinions.getRecords(),
            listOpinions.getCurrent(),listOpinions.getSize(),listOpinions.getPages()));
    }


}
