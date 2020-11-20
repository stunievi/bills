package com.yishudan.bills.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void login() {
        List list = new ArrayList<String>();
        list.add(2);
        list.add("22");
        for (Object o : list) {
            System.err.println(o instanceof Integer);
            System.err.println(o instanceof String);
        }
    }
}