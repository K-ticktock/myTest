package com.demo.test.test1.collection;

import java.util.Collection;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args){
        TreeSet<Student> set = new TreeSet<Student>();
        set.add(new Student(1,"zouyanping"));
        set.add(new Student(2,"chentianxiu"));
        set.add(new Student(3,"zhangsongyu"));
        set.add(new Student(4,"zhangmantang"));
        set.add(new Student(5,"jiaozheng"));
        set.add(new Student(6,"yinweigang"));
        for(Student s:set){
            System.out.println(s.getAge()+"========="+s.getName());
        }
    }
}
