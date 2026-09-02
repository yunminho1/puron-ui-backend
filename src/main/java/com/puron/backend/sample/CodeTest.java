package com.puron.backend.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeTest {
    public static void main(String[] arr){
        // 배열 만들기
        int[] arry = {1, 2, 3, 4, 5};
        int sum = 0;
        for(int i=0;i<arry.length;i++){
            sum = sum+i;
        }
        // 결과 출력
        System.out.println(sum);


        String text = "hello";


        StringBuffer bufferText= new StringBuffer(text);
        System.out.println(bufferText.reverse().toString());

        System.out.println(text.substring(0,3));

        char[] testArry = text.toCharArray();
        System.out.println(testArry);

        int[][] grid = {{111,222,333},{333,2222,111},{333,222,111}};

        for(int i=0; i<3; i++){
            for(int n=0; n<3;n++){
                int i1 = grid[i][n];
                System.out.println(i1);
            }
        }



        int[] sortArray = {3, 1, 4, 1, 5, 9, 2};
        Arrays.sort(sortArray);
        System.out.println(Arrays.toString(sortArray));

        Integer[] sortArray2 = {3, 1, 4, 1, 5, 9, 2};
        Arrays.sort(sortArray2, Integer::compare);
        System.out.println(Arrays.toString(sortArray2));

        String[] textSort = {"a","ab","abc"};
        Arrays.sort(textSort,(a,b)->b.length()-a.length());
        System.out.println(Arrays.toString(textSort));


        int[] target = {2, 7, 11, 15};
        int targetNumber = 9;

        Map<Integer,Integer> cahrgiMap = new HashMap<>();
        String lastText = "";

        for(int i=0; i<target.length;i++){
            int carhgiNum = targetNumber - target[i];
            if(carhgiNum > 0 && cahrgiMap.containsKey(carhgiNum) ){
                lastText = cahrgiMap.get(carhgiNum) + "+" + target[i];
                break;
            }

            cahrgiMap.put(target[i],target[i]);

        }
        System.out.println(lastText);



        String[] testSample = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String,Integer> countMap = new HashMap<>();
        for(String name : testSample){
            countMap.put(name,countMap.getOrDefault(name,0)+1);
        }
        System.out.println(countMap);
    }
}
