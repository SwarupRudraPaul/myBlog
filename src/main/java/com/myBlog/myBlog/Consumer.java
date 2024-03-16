package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;

public class Consumer {

    public static void main(String[] args) {
//        Consumer<Integer> val = no -> System.out.println(no);
//        val.accept(100);

        List<String> lists = Arrays.asList("Swarup", "Rudra", "Paul");
        java.util.function.Consumer<String> val = list -> System.out.println(list);
        lists.forEach(val);
    }
}
