package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Predicate2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 25, 56, 84, 75, 24, 68, 42, 16);
        List<Integer> collect = list.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        System.out.println(collect);
    }
}
