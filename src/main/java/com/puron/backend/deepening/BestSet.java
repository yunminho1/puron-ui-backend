package com.puron.backend.deepening;

public class BestSet {
    //        난이도: Level 3
//
//        입국심사를 위해 각 심사대 앞에서 기다리고 있다. 각 심사대는 다른 시간을 소요한다.
//
//                n명이 모두 입국심사를 완료하는 데 걸리는 최소 시간을 구하시오.
//
//        입출력 예:
//
//        입력: n = 6, times = [7, 10]
//        출력: 28
//
//        제약조건:
//
//        n은 1 이상 1,000,000,000 이하이다.
//                times의 길이는 1 이상 100 이하이다.
    public int[] solution(int n, int s) {
        // n개 수의 합이 s가 되면서 곱이 최대

        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int quotient = s / n;    // 기본값
        int remainder = s % n;   // 분배할 나머지

        // 모든 원소를 quotient로 초기화
        for (int i = 0; i < n; i++) {
            answer[i] = quotient;
        }

        // 뒤에서부터 remainder개만큼 1씩 더하기
        for (int i = n - remainder; i < n; i++) {
            answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args) {

        BestSet bs = new BestSet();

        // 테스트 1
        int[] result1 = bs.solution(66, 100);
        System.out.print("n=2, s=9: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println("(곱: " + (result1[0] * result1[1]) + ")");

        // 테스트 2
        int[] result2 = bs.solution(3, 12);
        System.out.print("n=3, s=12: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println("(곱: " + (result2[0] * result2[1] * result2[2]) + ")");

        // 테스트 3
        int[] result3 = bs.solution(3, 13);
        System.out.print("n=3, s=13: ");
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println("(곱: " + (result3[0] * result3[1] * result3[2]) + ")");
    }
}
