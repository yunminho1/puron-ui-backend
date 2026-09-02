package com.puron.backend.sample;

import java.util.ArrayList;
import java.util.List;

public class program {
    static long solution(int[] common) {
        int n = common.length;

        long diff1 = common[1] - common[0];
        long diff2 = common[2] - common[1];

        if(diff1 == diff2){
            return common[n - 1] + diff1;
        } else {
            long ratio = common[1] / common[0];
            return (long)common[n - 1] * ratio;
        }

    }
    public static int[] solution2(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0; i<num_list.length; i++){
            int idx = num_list.length-1;
            answer[i] = num_list[idx-i];
        }
        return answer;
    }
    public static void main(String[] arr){
        solution2(new int[]{2,4,8});
        System.out.println(solution2(new int[]{2,4,8}));

    }
}
