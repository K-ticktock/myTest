package com.demo.test.test2;

public class TestDemo {
    Boolean[] a = new Boolean[5];

    String str = new String("good");
    char[] ch = { 'a' , 'b' , 'c' };
    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        demo.display();
        demo.change(demo.str,demo.ch);
        System.out.println(demo.str+"and"+demo.ch);
        System.out.println(demo.ch[0]);
        short a=32767;
        short b=2;
        short c=(short) (a*b);
        int d=a*b;
        System.out.println(c);
        System.out.println(d);
    }

    void display(){
        System.out.println(a[4]);
    }

    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}
