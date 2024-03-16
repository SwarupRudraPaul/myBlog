package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass1 {

    public static void main(String[] args) {

        List<Login> lists = Arrays.asList(
                new Login("swarup","RP"),
                new Login("jagriti","p")
        );
        List<LoginDto> collect = lists.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(collect);
    }

     static LoginDto mapToDto(Login login){
        LoginDto dto = new LoginDto();
        dto.setUserName(login.getUserName());
        dto.setPassword(login.getPassword());
        return dto;
    }
}
