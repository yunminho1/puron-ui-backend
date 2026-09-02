package com.puron.backend.sample;

import java.util.*;

public class Greedy2Test {
    static int minues(int price, int totalNum,Map<Integer,Integer> reaultMap){
        int modNum = totalNum - price;
        if(modNum>0&&price<=totalNum){
            reaultMap.put(price,reaultMap.getOrDefault(price,0)+1);
            totalNum = minues(price,modNum,reaultMap);
        }

        return totalNum;
    }

    public static void main(String[] arr){
//        동전 종류: [500, 100, 50, 10, 5, 1]
//        거슬러줄 금액: 1237원
//
//        최소 개수의 동전으로 거슬러주려면?
//        1237원을 거슬러주자:
//
//        500원: 1237 ÷ 500 = 2개 (남은돈: 237원)
//        100원: 237 ÷ 100 = 2개 (남은돈: 37원)
//        50원: 37 ÷ 50 = 0개 (남은돈: 37원)
//        10원: 37 ÷ 10 = 3개 (남은돈: 7원)
//        5원: 7 ÷ 5 = 1개 (남은돈: 2원)
//        1원: 2 ÷ 1 = 2개 (남은돈: 0원)
//
//        총 개수: 2 + 2 + 0 + 3 + 1 + 2 = 10개
        Integer[] priceList = {500, 100, 50, 10, 5, 1};
        Arrays.sort(priceList,(a,b)->Integer.compare(b,a));
        int totalNum = 1237;
        Map<Integer,Integer> reulstMap = new LinkedHashMap<>();
        for(Integer price : priceList){
            totalNum= minues(price,totalNum,reulstMap);
        }

        for(Integer key :reulstMap.keySet()){
            System.out.println(key+":"+reulstMap.get(key));
        }
    }
}
