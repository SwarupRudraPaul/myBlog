package com.myBlog.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass2 {

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee("swarup","Agartala",24),
                new Employee("rudra","Agartala",26),
                new Employee("paul","udaipur",24)
        );

//        List<Employee> collect = emps.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());
//
//        collect.forEach(employee -> {
//            System.out.println(employee.getName());
//            System.out.println(employee.getCity());
//            System.out.println(employee.getAge());
//        });

//        List<Employee> name = emps.stream().filter(e -> e.getName().startsWith("s")).collect(Collectors.toList());
//        name.forEach(n->{
//            System.out.println(n.getName());
//            System.out.println(n.getCity());
//            System.out.println(n.getAge());
//        });

        Map<Integer, List<Employee>> collect = emps.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        System.out.println(collect);

        collect.forEach((age,emp)->{
//            System.out.println(age);
            emp.forEach(em->{
                System.out.println(em.getName());
                System.out.println(em.getCity());
                System.out.println(em.getAge());
            });
        });
    }
}
