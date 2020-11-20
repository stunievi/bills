package com.yishudan.bills.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Stunievi
 * @time: 2020/11/20 12:44
 */
@RestController
@RequestMapping("login")
public class Logincontroller {
    @GetMapping("login")
    public String login(){
        List list = new ArrayList<String>();
        list.add(2);
        list.add("22");
        return "2222";
    }
}
