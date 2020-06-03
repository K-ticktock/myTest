package com.demo.test.test1.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        Map map1 = new HashMap();
        map1.put("aa","a1");
        map1.put("bb","b1");
        map1.put("cc","c1");
        Map map2 = new HashMap();
        map2.put("aa","a2");
        map2.put("bb","b2");
        map2.put("cc","c3");
        Map map3 = new HashMap();
        map3.put("aa","a1");
        map3.put("dd","b4");
        map3.put("ee","c5");
        Map map4 = new HashMap();
        map4.put("aa","a2");
        map4.put("dd","b4");
        map4.put("ee","c6");
        List<Map> list1 = new ArrayList<>();
        List<Map> list2 = new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        list2.add(map3);
        list2.add(map4);
        Map<String,Map> mapMap = new HashMap<>();
        for(Map map:list1){
            String key = map.get("aa").toString();
            mapMap.put(key,map);
        }
        for(Map map:list2){
            String key = map.get("aa").toString();
            if(mapMap.containsKey(key)){
                mapMap.get(key).putAll(map);
            }
        }
        System.out.println(mapMap);
        mapMap.entrySet().iterator();
        System.out.println(mapMap.values().stream().collect(Collectors.toList()));
    }

}
