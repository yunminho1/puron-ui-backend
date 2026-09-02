package com.puron.backend.sample;

import java.util.*;
import java.util.stream.Collectors;

public class test {

//    양의 정수 n을 연속된 양의 정수의 합으로 표현하는 방법의 수를 구하시오.
//
//    입출력 예:
//
//    입력: n = 15
//    출력: 4
//
//    설명:
//
//            15 = 15
//            15 = 7+8
//            15 = 4+5+6
//            15 = 1+2+3+4+5
    static int solution(int n){
        int count=0;
        for(int i=1; i<=n; i++){
            int sum=0;
            for(int j=i;j<=n;j++){
                sum +=j;
                if(sum==n){
                    count++;
                    break;
                }
            }
        }

        return count ;
    }

    static int allSum(int[] numbers){
//        정수 배열 numbers가 주어질 때, 각 원소가 한 번씩 사용되어야 한다.
//
//                모든 원소 쌍 (i, j)에 대해 numbers[i] * numbers[j]의 합에서, numbers[i] + numbers[j]의 합을 뺀 값을 구하시오.
//
//                입출력 예:
//
//        입력: numbers = [1, 2, 3]
//        출력: 2
//
//        설명:
//
//        (1*2) + (1*3) + (2*1) + (2*3) + (3*1) + (3*2)
//                - ((1+2) + (1+3) + (2+1) + (2+3) + (3+1) + (3+2))
//                = 22 - 20 = 2

        int sumNumber = 0;
        int comNumber = 0;
        int min=0;
        for(int i=0;i<numbers.length;i++){
            int iData = numbers[i];
//            List<Integer> restNumbers = Arrays.stream(numbers) // int[] 바로 스트림 변환
//                    .filter(num -> num != data) // data와 같지 않은 것만 남김
//                    .boxed() // int를 Integer로 변환
//                    .toList();

            for(int j=0;j<numbers.length;j++){
                int jData = numbers[j];
                if(iData==jData){
                   continue;
                }

                comNumber += (iData*jData);
                sumNumber += (iData+jData);
            }

        }

        return sumNumber-comNumber;
    }

    static int computer(int n, int[][] computers){
        boolean[] visited = new boolean[n];
        int result=0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, computers, visited);  // 재귀로 깊이 탐색
                result++;
            }
        }

        return result;
    }
    static void dfs(int node,int[][] computers, boolean[] visited){
        visited[node]=true;
        for(int j=0;j<computers[node].length;j++){
            int[] data = computers[node];
            if(data[j]==1 && !visited[j]){
                dfs(j, computers, visited);  // 깊이까지 재귀
            }
        }
    }

    public static void main(String[] arr){
        System.out.println(solution(3));
        System.out.println(allSum(new int[]{1,2,3}));
        System.out.println(computer(4,new int[][]{
                {1,0,1,0},
                {0,0,1,0},  // ← 1이 2와도 연결!
                {1,0,1,0},  // ← 2가 1과 연결
                {0,0,0,1}}));
    }
}
