package com.puron.backend.sample;

import java.util.HashMap;
import java.util.Map;

public class DpTest {
    //피보나치 문제
    static Map<Integer, Long> memo = new HashMap<>();
    static long countWays(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;  // ✅ 수정
        if(n == 3) return 4;  // ✅ 수정
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        long result = countWays(n-1)+countWays(n-2)+countWays(n-3);
        memo.put(n,result);
        return result;
    }

    public static void main(String[] arr){
        System.out.println(countWays(1));
        System.out.println(countWays(2));
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(10));

    }
}
