package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Predicate3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ram", "Sam", "Raghav", "Avy", "Sandy");
        List<String> r1 = list.stream().filter(x -> x.startsWith("R")).collect(Collectors.toList());
        List<String> r2 = list.stream().filter(x -> x.startsWith("S")).collect(Collectors.toList());
        List<String> r3 = list.stream().filter(x -> x.endsWith("m")).collect(Collectors.toList());
        List<String> r4 = list.stream().filter(x -> x.endsWith("y")).collect(Collectors.toList());
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
