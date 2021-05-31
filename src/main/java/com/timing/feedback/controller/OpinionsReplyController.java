package com.timing.feedback.controller;


import com.timing.feedback.bo.OpinionsReplyBO;
import com.timing.feedback.entity.OpinionsReply;
import com.timing.feedback.service.OpinionsReplyService;
import com.timing.feedback.utils.CheckParamUtil;
import com.timing.feedback.vo.ResultCodeEnum;
import com.timing.feedback.vo.ResultVO;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@RestController
@RequestMapping("/opinionsReply")
public class OpinionsReplyController {

    @Resource
    private OpinionsReplyService opinionsReplyService;

    @PostMapping("")
    public ResultVO replyOpinions(@RequestBody @Valid OpinionsReplyBO opinionsReplyBO,BindingResult bindingResult){
        //参数校验
        CheckParamUtil.check(bindingResult,ResultCodeEnum.PARAM_NOT.getMessage());
        return opinionsReplyService.replyOpinions(opinionsReplyBO);
    }

}

