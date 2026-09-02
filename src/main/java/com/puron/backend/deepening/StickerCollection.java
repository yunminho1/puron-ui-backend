package com.puron.backend.deepening;

import java.lang.reflect.Array;

public class StickerCollection {
//    원형 배열의 각 원소가 스티커인데, 한 개의 스티커를 획득할 때마다 그 스티커와 인접한 스티커는 제거된다.
//
//    배열의 처음과 끝도 인접하다고 본다. 스티커 점수의 최댓값을 구하시오.
//
//    입출력 예:
//
//    입력: stickers = [14, 6, 5, 11, 3, 9, 2, 10]
//    출력: 44
//
//    제약조건:
//
//    stickers의 길이는 1 이상 100,000 이하이다.
//    각 스티커의 점수는 1 이상 100 이하이다.

    //DP문제 임 선택/미선택의 뒤에 더하기
    static int solution(int[] stickers) {
        int n = stickers.length;
        if(n == 1) return stickers[0];

        // 원형이므로 첫 번째 포함/미포함으로 나눔
        int case1 = maxSticker(stickers, 0, n - 2);  // 마지막 제외
        int case2 = maxSticker(stickers, 1, n - 1);  // 첫 번째 제외

        return Math.max(case1, case2);
    }

    static int maxSticker(int[] stickers, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = stickers[start];
        if(len > 1) {
            dp[1] = Math.max(stickers[start], stickers[start + 1]);
        }

        for(int i = 2; i < len; i++) {
            // 현재 스티커를 선택: i-2까지의 최대 + 현재
            // 현재 스티커를 미선택: i-1까지의 최대
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + stickers[start + i]);
        }
//        1,6,6,13

        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] stickers = {1, 6, 5, 7, 13};
        System.out.println("결과: " + solution(stickers));  // 출력: 44
    }
}