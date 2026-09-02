package com.puron.backend.deepening;

public record Fibonacci() {
    static int solution(int n){
        int result = 0;
        int mod = 1000000007;
        if(n<0){
            return -1;
        }

        long[] dp = new long[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }

        return (int)dp[n];
    }
    public static void main(String[] arr){
        System.out.println(solution(4));
    }
}
