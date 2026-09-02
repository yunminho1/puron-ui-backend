package com.puron.backend.deepening;

import java.util.HashSet;
import java.util.Set;

public class Puddle {
//    집에서 학교까지 m×n 격자에서 (0,0)에서 (n-1,m-1)로 이동한다.
//
//    오른쪽 또는 아래로만 이동할 수 있고, 일부 칸은 지나갈 수 없다(puddles).
//
//    최단 경로의 수를 1,000,000,007로 나눈 나머지로 반환하시오.
//
//    입출력 예:
//
//    입력: m = 4, n = 3, puddles = [[2,2]]
//    출력: 4
//
//    제약조건:
//{{0,0},{0,0},{0,0},{0,0}}
//
//    m, n은 1 이상 100 이하이다.
    static int solution(int m, int n, int[][] puddles){
        int MOD = 1000000007;
        Set<String> puddSet = new HashSet<>();
        for(int i=0; i<puddles.length;i++){
            puddSet.add(puddles[i][0]+","+puddles[i][1]);
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;


        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if (i == 0 && j == 0){
                    continue;
                }

                if(puddSet.contains(i+","+j)){
                    dp[i][j]=0;
                    continue;
                }

                int from_up = (i > 0) ? dp[i-1][j] : 0;
                int from_left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j]=(from_up + from_left) % MOD;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] arr){
        System.out.println(solution(4,3,new int[][]{{2,2},{3,2}}));
    }
}
