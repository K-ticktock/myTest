package com.demo.test.test1.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetTest {
    public static void main(String[] args){
        Collection collection1 = new HashSet();
        collection1.add("aa");
        collection1.add("bb");
        collection1.add(22);
        collection1.add("cc");
        collection1.add(null);
        System.out.println(collection1.size());
        System.out.println(collection1.hashCode());
        System.out.println(collection1);

        Collection collection2 = new LinkedHashSet();
        collection2.add("aa");
        collection2.add("bb");
        collection2.add(22);
        collection2.add("cc");
        collection2.add(null);
        System.out.println(collection2.size());
        System.out.println(collection2.hashCode());
        System.out.println(collection2);

        System.out.println(collection1==collection2);
        System.out.println(collection1.equals(collection2));
    }
}
