package com.puron.backend.sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class brutpostTest {
    //[1, 2, 3, 4, 5]
    public static void main(String[] arr){
        int[] numArr = {3, 5, 2, 8, 4};
        int target = 10;
        Set<Integer> setInt = new HashSet<>();

        for(int num : numArr){
            int min = target - num;
            if(setInt.contains(num)){
                System.out.println(min+"+"+num);
            }
            setInt.add(min);
        }
    }

}
