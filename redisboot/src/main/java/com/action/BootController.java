package com.action;

import com.alibaba.fastjson.JSON;
import java.util.*;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;
import com.utils.*;
import com.entity.*;

@Controller
public class BootController {

    @Autowired
    private RedisClient redisClinet;

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView mvo) throws Exception{
        System.out.println(" --- test ");

        Goods good= new Goods();
        good.setName( "洗衣机" );
        good.setNum(400);
        good.setPrice(693);

        redisClinet.set("product",good);
        Goods pobj =  (Goods)redisClinet.get("product");
        System.out.println(" pobj = "+pobj);
        long num = redisClinet.del("product");
        System.out.println(" del num = "+num);

        mvo.setViewName("success");
        return mvo;
    }
}
