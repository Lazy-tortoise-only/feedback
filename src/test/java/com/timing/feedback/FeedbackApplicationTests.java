package com.timing.feedback;

import com.timing.feedback.entity.CustomerService;
import com.timing.feedback.entity.UserOpinionsCount;
import com.timing.feedback.mapper.CustomerServiceMapper;
import com.timing.feedback.mapper.UserOpinionsCountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.locks.LockSupport;

@SpringBootTest
class FeedbackApplicationTests {
    Thread t1,t2;

    @Resource
    UserOpinionsCountMapper userOpinionsCountMapper;

    @Resource
    CustomerServiceMapper customerServiceMapper;
    @Test
    void contextLoads() {
        t1=new Thread(() -> {
            for (int i=0;i<100;i++){
                System.out.println(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2=new Thread(() -> {
            for (int i=0;i<100;i++){
                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    void updateTest() {
        customerServiceMapper.insert(new CustomerService("user","$2a$10$Jc/wQL1rKsBfVdjT8o5z0eE3imnfdptOCs1PkKC8Ygt4.mPNHFG2i","lisa"));
        customerServiceMapper.insert(new CustomerService("user","$2a$10$Jc/wQL1rKsBfVdjT8o5z0eE3imnfdptOCs1PkKC8Ygt4" +
            ".mPNHFG2i","nick"));
    }



}
