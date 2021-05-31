package com.timing.feedback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timing.feedback.entity.CustomerService;
import com.timing.feedback.mapper.CustomerServiceMapper;
import com.timing.feedback.service.CustomerServiceService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cwh
 * @since 2021-05-27
 */
@Service
public class CustomerServiceServiceImpl extends ServiceImpl<CustomerServiceMapper, CustomerService> implements CustomerServiceService {

}
