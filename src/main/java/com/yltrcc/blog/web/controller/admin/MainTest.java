package com.yltrcc.blog.web.controller.admin;

import cn.hutool.crypto.SecureUtil;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("123"));
    }
}
