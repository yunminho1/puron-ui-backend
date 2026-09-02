package com.puron.backend.sample;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class alpabetTest {
    public static void main(String[] arr){
        String test = "abccccdd";
        Map<Character,Integer> setData = new LinkedHashMap<>();
        char[] arryData = test.toCharArray();

        for(int i=0;i<arryData.length;i++){
            char diff = arryData[i];
            int count = 1;
            for(int j=i+1;j<arryData.length;j++){
                char diff2 = arryData[j];
                if(diff==diff2){
                    count++;
                    i++;
                }else{
                    break;
                }
            }
            setData.put(diff, count);
        }

        for(Character key : setData.keySet()){
            System.out.print(key+""+setData.get(key));
        }




//        for(char text : test.toCharArray()){
//            maxCount++;
//
//
//            if (Character.isLetter(text)) {
//                String key = String.valueOf(Character.toLowerCase(text));
//                int count = setData.getOrDefault(key, 0) + 1;
//                setData.put(key,count);
//
//                if(count>maxCount){
//                    resultKey = key;
//                }else if(count==maxCount && key.compareTo(resultKey)<0){
//                    resultKey = key;
//                }
//           }
//
//        }
    }
}
