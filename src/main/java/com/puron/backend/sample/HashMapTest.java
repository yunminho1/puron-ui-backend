package com.puron.backend.sample;

import java.util.*;

public class HashMapTest {

    static class Product{
        String name;
        String sort;
        int count;

        Product(String name, String sort, int count){
            this.name = name;
            this.sort = sort;
            this.count = count;
        }
    }
    public static void main(String[] arr){
//        우유        유제품      10
//        계란        유제품      5
//        요거트      유제품      8
//        고기        육류        12
//        소시지      육류        15
//        채소        신선식품    7
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("우유","유제품",10));
        productList.add(new Product("계란","유제품",5));
        productList.add(new Product("요거트","유제품",8));
        productList.add(new Product("고기","육류",12));
        productList.add(new Product("소시지","육류",15));
        productList.add(new Product("채소","신선식품",7));

        Map<String,Integer> resultMap = new LinkedHashMap<>();

        productList.forEach((dataMap)->{
            String key = dataMap.sort;
            int keyCount = resultMap.getOrDefault(key,0);
            resultMap.put(key,keyCount+dataMap.count);
        });

        for(Map.Entry<String,Integer> data:resultMap.entrySet()){
            System.out.println(data.getKey()+":"+data.getValue());
        }
    }
}
