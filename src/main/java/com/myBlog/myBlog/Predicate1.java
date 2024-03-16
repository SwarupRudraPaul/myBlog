package com.myBlog.myBlog;

import java.util.function.Predicate;

public class Predicate1 {

    public static void main(String[] args) {
        Predicate<Integer> p = x->x%2==0;
        boolean test = p.test(10);
        System.out.println(test);
    }
}
