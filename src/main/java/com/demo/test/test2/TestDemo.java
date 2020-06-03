package com.demo.test.test2;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    Boolean[] a = new Boolean[5];

    String str = new String("good");
    char[] ch = { 'a' , 'b' , 'c' };
    public static void main(String[] args) {
        List<String> alist = new ArrayList<>();
        alist.add("zhangsan");
        alist.add("lisi");
        alist.add("wangwu");
        alist.add("zhaoliu");

        for(String a:alist){
            String b = "diaochan";
            String c = a;
            a = b;
            b = c;
            System.out.println("now is ------------------");
            System.out.println(c);
            System.out.println(a);
            System.out.println(b);
        }

        for(int i =0;i<10;i++){
            System.out.println(i);
            for(int j = 10;j<20;j++){
                if(j==18){
                    break;
                }
                System.out.println(j);
            }
        }
    }

    void display(){
        System.out.println(a[4]);
    }

    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}
