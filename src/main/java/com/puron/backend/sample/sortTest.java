package com.puron.backend.sample;

import java.util.*;

public class sortTest {
    static class Product {
        String name;
        int price;

        Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] arr){

        List<Product> listMap = new ArrayList<>();
        listMap.add(new Product("우유",5000));
        listMap.add(new Product("계란",3000));
        listMap.add(new Product("요거트",3000));
        listMap.add(new Product("고기",10000));
        listMap.add(new Product("버터",5000));

        listMap.sort((product1, product2) -> {
            int price1 = product1.price;
            int price2 = product2.price;
            int result = Integer.compare(price1,price2);
            if(result ==0){
                return product1.name.compareTo(product2.name);
            }
            return result;
        });

        for (Product p : listMap) {
            System.out.println(p.name + " " + p.price);
        }

        String[][] data= {{"우유","5000"},{"계란","3000"},{"요거트","3000"},{"고기","10000"},{"버터","5000"}};
        Arrays.sort(data,(p1,p2)->{
            int price1 = Integer.parseInt(p1[1]);
            int price2 = Integer.parseInt(p2[1]);
            int result =Integer.compare(price1,price2);
            if(result==0){
                return p1[0].compareTo(p2[0]);
            }
            return result;
        });
        for (String[] product : data) {
            System.out.println(product[0] + " " + product[1]);
        }
    }
}
