package com.timing.feedback.controller;


import com.timing.feedback.bo.OpinionsBO;
import com.timing.feedback.entity.Opinions;
import com.timing.feedback.entity.OpinionsReply;
import com.timing.feedback.service.OpinionsReplyService;
import com.timing.feedback.service.OpinionsService;
import com.timing.feedback.utils.CheckParamUtil;
import com.timing.feedback.vo.ResultCodeEnum;
import com.timing.feedback.vo.ResultVO;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Validated
@RestController
@RequestMapping("/opinion")
public class OpinionsController {
    @Resource
    private OpinionsService opinionsService;



    @PostMapping("")
    public ResultVO saveOpinions(@RequestBody @Valid OpinionsBO opinionsBO,
        BindingResult bindingResult){
        //参数检验
        CheckParamUtil.check(bindingResult, ResultCodeEnum.PARAM_NOT.getMessage());


        return  opinionsService.saveOpinionsAndCount(opinionsBO);
    }



    @GetMapping("/list/{userId}")
    public ResultVO listOpinions(@RequestParam(value = "current", defaultValue = "1") @Min(value = 0) int current,
                                 @RequestParam(value = "size", defaultValue = "5")  @Min(value = 0)int size,
                                 @PathVariable @Min(value = 0) int userId ){

        return  opinionsService.listOpinions(current,size,userId);
    }



}

