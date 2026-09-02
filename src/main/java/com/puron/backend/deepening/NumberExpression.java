package com.puron.backend.deepening;

public class NumberExpression {
//    양의 정수 n을 연속된 양의 정수의 합으로 표현하는 방법의 수를 구하시오.
//
//    입출력 예:
//
//    입력: n = 15
//    출력: 4
//
//    설명: 15 = 15, 15 = 7+8, 15 = 4+5+6, 15 = 1+2+3+4+5
//
//    제약조건:
//
//    n은 1 이상 10,000 이하이다.
    static int solution(int n) {
        int count = 0;

        for(int i = 1; i <= n; i++) {  // 시작점
            int sum = 0;
            for(int j = i; j <= n; j++) {  // 끝점
                sum += j;
                if(sum == n) {
                    count++;  // n을 만들었으면 카운트
                    break;
                } else if(sum > n) {
                    break;  // 이상 넘어가면 중단
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("결과: " + solution(15));
        // 15 = 15
        // 15 = 7+8
        // 15 = 4+5+6
        // 15 = 1+2+3+4+5
        // 출력: 4
    }
}
