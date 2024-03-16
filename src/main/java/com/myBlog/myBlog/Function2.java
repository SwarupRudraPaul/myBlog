package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Function2 {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(10, 50, 30, 40, 90, 70);
//        List<Integer> v1 = list.stream().map(i -> i / 2).collect(Collectors.toList());
//        List<Integer> v2 = list.stream().map(i -> i * 2).collect(Collectors.toList());
//        System.out.println(v1);
//        System.out.println(v2);

//        List<String> list = Arrays.asList("Swarup", "Rudra", "Paul");
//        List<String> d1 = list.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
//        List<String> d2 = list.stream().map(i -> i.toLowerCase()).collect(Collectors.toList());
//        System.out.println(d1);
//        System.out.println(d2);

//        List<Integer> list = Arrays.asList(10, 50, 40, 25, 35, 48);
//        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
//        System.out.println(sorted);

        List<Integer> list = Arrays.asList(10, 20, 50, 40, 20, 10, 80, 45, 75, 80);
        List<Integer> unique = list.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(unique);
    }
}
