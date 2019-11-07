package com.demo.test.test1.test;

public class Student {
    int id;
    int age;
    int num;

    public Student() {
    }

    public Student(int id, int age, int num) {
        this.id = id;
        this.age = age;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
