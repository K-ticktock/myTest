package com.demo.test.test1.test;

import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TestListMerge {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        Student st1 = new Student(1,10,69);
        Student st2 = new Student(2,11,75);
        Student st3 = new Student(3,10,89);
        Student st4 = new Student(4,11,89);
        Student st5 = new Student(1,11,91);
        list1.add(st1);
        list1.add(st2);
        list1.add(st3);
        list1.add(st4);
        list1.add(st5);
        System.out.println(list1);
        Map<String,List<Student>> map = list1.stream().collect(Collectors.groupingBy(student -> group(student)));
        System.out.println(map);

        List<Student> list3 = new ArrayList<>();
        list1.stream().collect(Collectors.groupingBy(student -> group(student))).forEach((K,V)->{
            Student newStudent = V.get(0);
            int num = 0;
            for(Student st:V){
                num+=st.getNum();
            }
            newStudent.setNum(num);
            list3.add(newStudent);
        });
        System.out.println(list3);
        //合并重复数据
        HashMap<String,Student> tempMap = new HashMap<>();
        Iterator<Student> iterator = list1.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();
            String key = ""+stu.getId();
            //containKey(Object key)该方法判断Map集合中是否包含指定的键名，如果包含返回true，不包含返回false
            //containValue(Object value)该方法判断Map集合中是否包含指定的键值，如果包含返回true，不包含返回false
            if(tempMap.containsKey(key)){
//                Student newStu = new Student();
//                BeanUtils.copyProperties(stu,newStu);
//                //合并相同key的value
//                newStu.setNum(tempMap.get(key).getNum()+stu.getNum());
//                tempMap.put(key,newStu);
                Student newStu = tempMap.get(key);
                //合并相同key的value
                newStu.setNum(newStu.getNum()+stu.getNum());
                tempMap.put(key,newStu);
            }else{
                tempMap.put(key,stu);
            }
        }
//        for(Student stu:list1){
//            String key = ""+stu.getId();
//            //containKey(Object key)该方法判断Map集合中是否包含指定的键名，如果包含返回true，不包含返回false
//            //containValue(Object value)该方法判断Map集合中是否包含指定的键值，如果包含返回true，不包含返回false
//            if(tempMap.containsKey(key)){
//                Student newStu = new Student();
//                BeanUtils.copyProperties(stu,newStu);
//                //合并相同key的value
//                newStu.setNum(tempMap.get(key).getNum()+stu.getNum());
//                tempMap.put(key,newStu);
//            }else{
//                tempMap.put(key,stu);
//            }
//        }
        list2.addAll(tempMap.values());
        long end = System.currentTimeMillis();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(end-start);
    }
    private static String group(Student student){
        return ""+student.getId();
    }
}
