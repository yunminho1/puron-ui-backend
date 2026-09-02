package com.puron.backend.deepening;

public class GridPathDP {
    //DP 문제
    //        m×n 격자에서 (0,0)에서 (m-1,n-1)로 이동하는 경로의 수를 구하시오.
//
//                격자의 각 칸은 0 또는 1로 표시된다.
//        0은 이동 가능, 1은 이동 불가능이다.
//                문제 조건: 게임을 모두 완료한 경로의 개수를 1,000,000,007로 나눈 나머지를 출력한다.
//
//        입출력 예:
//
//        입력: m = 3, n = 3, cityMap = [[0,0,0],[0,0,0],[0,0,0]]
//        출력: 6
//
//        제약조건:
//
//        m, n은 1 이상 100 이하이다.
    static int solution(int m, int n, int[][] cityMap) {
        int MOD = 1000000007;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) continue;

                int from_up = (i > 0) ? dp[i-1][j] : 0;
                int from_left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j] = (from_up + from_left) % MOD;
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        // 테스트 1
        int[][] map1 = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(solution(3, 3, map1));  // 6

        // 테스트 2
        int[][] map2 = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution(3, 3, map2));  // 2
    }
}
