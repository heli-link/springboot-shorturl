package com.alpha.springboot;

import com.alpha.springboot.bean.MyUrl;
import com.alpha.springboot.controller.SUrlController;
import com.alpha.springboot.mapper.UrlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.ServletOutputStream;

@SpringBootTest
class SpringbootShorturlApplicationTests {

    @Autowired
    UrlMapper urlMapper;
    @Test
    void contextLoads() {
        MyUrl aLong = urlMapper.selBySUrl("long");
        System.out.println(aLong);
    }
    @Autowired
    SUrlController sUrlController;
    @Test
    void randomtest(){
        String rendom = sUrlController.getRendom(8);
        System.out.println("随机数 = "+rendom);
    }

}
