package com.myBlog.myBlog;

import java.util.function.Function;

public class Function1 {
    public static void main(String[] args) {
//        Function<String,Integer> length = fn->fn.length();
//        Integer result = length.apply("swarup");
//        System.out.println(result);

            Function<Integer,Integer> val = fn->fn+10;
         Integer result = val.apply(50);
         System.out.println(result);
    }
}
