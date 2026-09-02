package com.puron.backend.deepening;

public class ImmigrationCheckpoint {
//    입국심사를 위해 각 심사대 앞에서 기다리고 있다. 각 심사대는 다른 시간을 소요한다.
//
//    n명이 모두 입국심사를 완료하는 데 걸리는 최소 시간을 구하시오.
//
//    입출력 예:
//
//    입력: n = 6, times = [7, 10]
//    출력: 28
//
//    제약조건:
//
//    n은 1 이상 1,000,000,000 이하이다.
//    times의 길이는 1 이상 100 이하이다.
    public long solution(int n, int[] times) {
        // 1. 이진 탐색 범위
        long left = times[0];
        long right = (long) n * times[times.length - 1];  // 최대 시간

        // 2. 이진 탐색
        while (left < right) {
            long mid = left + (right - left) / 2;

            // mid분 동안 처리할 수 있는 인원
            long count = 0;
            for (int time : times) {
                count += mid / time;  // 각 심사대에서 처리 가능한 인원
                if (count >= n) break;  // 이미 충분하면 종료
            }

            if (count < n) {
                // 처리한 인원이 부족하면 더 많은 시간 필요
                left = mid + 1;
            } else {
                // 처리한 인원이 충분하면 더 적은 시간으로 시도
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        ImmigrationCheckpoint ic = new ImmigrationCheckpoint();

        // 테스트 1
        System.out.println("Test 1: " + ic.solution(6, new int[]{7, 10}));  // 28

//        // 테스트 2
//        System.out.println("Test 2: " + ic.solution(3, new int[]{6, 9, 60}));
//
//        // 테스트 3
//        System.out.println("Test 3: " + ic.solution(100, new int[]{1, 2, 3}));
    }
}
