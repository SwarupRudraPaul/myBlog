package com.myBlog.myBlog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class IMA_TestClass {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("testing"));
    }
}
