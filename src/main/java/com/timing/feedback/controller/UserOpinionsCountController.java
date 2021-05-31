package com.timing.feedback.controller;

import com.timing.feedback.service.UserOpinionsCountService;
import com.timing.feedback.vo.ResultCodeEnum;
import com.timing.feedback.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * <p>
 * 只记录未处理意见 前端控制器
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@RestController
@RequestMapping("/userOpinionsCount")
public class UserOpinionsCountController {
    @Resource
    UserOpinionsCountService userOpinionsCountService;


    @GetMapping("list")
    public ResultVO listUserOpinionsCount(@RequestParam(value = "current", defaultValue = "1") int current,
                                          @RequestParam(value = "size", defaultValue = "10")  int size){
        //参数检验
        if (current < 0 || size < 0){
            return ResultVO.error(ResultCodeEnum.PARAM_NOT);
        }

        return userOpinionsCountService.listUserCount(current,size);
    }
}

