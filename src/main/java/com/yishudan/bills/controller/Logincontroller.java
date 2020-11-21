package com.yishudan.bills.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Stunievi
 * @time: 2020/11/20 12:44
 */
@Api("登录")
@RestController
@RequestMapping("user")
public class Logincontroller {
    @ApiOperation("登录")
    @GetMapping("login")
    public String login(){
        List list = new ArrayList<String>();
        list.add(2);
        list.add("22");
        list:
        if( 1 == 1){
            break list;
        }

        return "2222";
    }
}
