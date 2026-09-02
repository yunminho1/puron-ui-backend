package com.puron.backend.deepening;

import java.util.HashSet;
import java.util.Set;

public class NRepresentation {
    //DP문제(모든 조합)
//    정수 N과 정수 number가 주어질 때, N과 +, -, *, / 4개의 연산을 사용하여 number를 만드는 최소 N의 개수를 구하시오.
//
//            예) N=5, number=12인 경우: 12 = 5 + 5 + (5/5) + (5/5) 로 총 N을 4번 사용.
//
//    입출력 예:
//
//    입력: N = 5, number = 12
//    출력: 4
//
//    제약조건:
//
//    N은 1 이상 9 이하이다.
//            number는 1 이상 32,768 이하이다.
    public int solution(int N, int number) {
        if (N == number) return 1;

        Set<Integer>[] dp = new Set[9];
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }

        dp[1].add(N);

        // 연결된 수들 미리 추가 (55, 555, ...)
        int connected = N;
        for (int i = 2; i <= 8; i++) {
            connected = connected * 10 + N;
            dp[i].add(connected);
        }

        // DP 계산
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i-j]) {
                        // 4가지 연산
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }

            // number를 찾았으면 즉시 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        NRepresentation problem = new NRepresentation();

        // 테스트 1
        System.out.println(problem.solution(5, 12));  // 4

        // 테스트 2
        System.out.println(problem.solution(2, 11));  // 3 (2+2+2+2+2+1은 안되고 다른 방법)
    }
}
