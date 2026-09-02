package com.puron.backend.deepening;

public class MukbangLive {
    public int solution(int[] food_times, long k) {
        // 원본 배열 복사
        int[] food = new int[food_times.length];
        System.arraycopy(food_times, 0, food, 0, food_times.length);

        int lastCompleted = -1;

        // k초 반복
        for (long time = 0; time < k; time++) {
            // 모든 음식에서 1씩 소비
            for (int i = 0; i < food.length; i++) {
                if (food[i] > 0) {
                    food[i]--;

                    // 음식이 완료되면 기록
                    if (food[i] == 0) {
                        lastCompleted = i;
                    }
                }
            }

            // 모든 음식이 0이 되면 리셋
            boolean allZero = true;
            for (int f : food) {
                if (f > 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                System.arraycopy(food_times, 0, food, 0, food_times.length);
                lastCompleted = -1;  // 리셋되면 초기화
            }
        }

        return lastCompleted;
    }

    public static void main(String[] args) {
        MukbangLive ml = new MukbangLive();

        System.out.println("=== 테스트 1 ===");
        int[] food1 = {3, 1, 2};
        int result1 = ml.solution(food1, 5);
        System.out.println("food_times: [3, 1, 2], k = 5");
        System.out.println("결과: " + result1);
        System.out.println("예상: 1\n");

        System.out.println("=== 테스트 2 ===");
        int[] food2 = {1, 1, 1, 1};
        int result2 = ml.solution(food2, 2);
        System.out.println("food_times: [1, 1, 1, 1], k = 2");
        System.out.println("결과: " + result2 + "\n");

        System.out.println("=== 테스트 3 ===");
        int[] food3 = {4, 3, 2};
        int result3 = ml.solution(food3, 10);
        System.out.println("food_times: [4, 3, 2], k = 10");
        System.out.println("결과: " + result3);
    }
}
