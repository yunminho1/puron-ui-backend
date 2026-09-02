package com.puron.backend.deepening;

public class CoinChange {
    public int solution(int[] coins, int amount) {
        // dp[i] = i원을 만드는 최소 동전 개수
        int[] dp = new int[amount + 1];

        // 초기값: 모두 불가능(무한대로 설정)
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;  // 0원: 동전 0개

        // 1원부터 amount원까지 모든 금액 계산
        for (int i = 1; i <= amount; i++) {
            // 각 동전을 시도
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }


        // 불가능하면 -1 반환
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        // 테스트 1
        int[] coins1 = {5, 3, 4};
        int amount1 = 6;
        System.out.println("테스트 1: " + amount1 + "원");
        System.out.println("동전: [1, 3, 4]");
        System.out.println("최소 동전 개수: " + cc.solution(coins1, amount1));
        System.out.println("답: 3+3 = 2개\n");

        // 테스트 2
        int[] coins2 = {1, 5, 10};
        int amount2 = 27;
        System.out.println("테스트 2: " + amount2 + "원");
        System.out.println("동전: [1, 5, 10]");
        System.out.println("최소 동전 개수: " + cc.solution(coins2, amount2));
        System.out.println();

        // 테스트 3 - 불가능한 경우
        int[] coins3 = {3, 4};
        int amount3 = 5;
        System.out.println("테스트 3: " + amount3 + "원");
        System.out.println("동전: [3, 4]");
        System.out.println("최소 동전 개수: " + cc.solution(coins3, amount3));
        System.out.println("답: 불가능 (-1)\n");

        // 테스트 4 - dp 과정 출력
        int[] coins4 = {1, 3, 4};
        int amount4 = 6;
        int[] dp = new int[amount4 + 1];
        for (int i = 1; i <= amount4; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        System.out.println("=== dp 계산 과정 ===");
        System.out.println("dp[0] = 0");

        for (int i = 1; i <= amount4; i++) {
            for (int coin : coins4) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            System.out.println("dp[" + i + "] = " + dp[i]);
        }
    }
}
