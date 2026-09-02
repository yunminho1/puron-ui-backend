package com.puron.backend.deepening;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    //        하드디스크는 0ms부터 시작해서 각 작업에 대해 [작업 소요 시간, 요청 시점]이 주어진다.
//
//        모든 작업을 처리할 때 평균 대기 시간을 최소화하려면 어떤 순서로 작업을 처리해야 할까? (작업이 도착하지 않은 경우, 처음 도착하는 작업까지 대기)
//
//        입출력 예:
//
//        입력: jobs = [[0, 3], [1, 9], [500, 6]]
//        출력: 1
//
//        제약조건:
//
//        jobs의 길이는 1 이상 500 이하이다.
//                jobs[i]는 [작업이 요청되는 시점, 작업의 소요 시간]이다.


    //        3-0 = 3
//                10-1=9
//                        506-500
    static int solution(int[][] jobs){
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);  // 요청시점 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);  // 소요시간 정렬
        int jobIdx = 0;
        int currentTime = 0;
        int totalWaitTime = 0;
        while (jobIdx<jobs.length || !pq.isEmpty()){
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pq.offer(jobs[jobIdx]);
                jobIdx++;
            }

            if(pq.isEmpty()) {
                // 처리할 게 없으면 다음 작업까지 점프
                currentTime = jobs[jobIdx][0];
            } else {
                int[] job = pq.poll();
                currentTime += job[1];
                totalWaitTime += currentTime - job[0];
            }

        }


//        for(int jobIdx=0; jobIdx<jobs.length;){
//            for(; jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime; jobIdx++) {
//                pq.offer(jobs[jobIdx]);
//            }
//
//            if(pq.isEmpty()) {
//                if(jobIdx < jobs.length) {
//                    currentTime = jobs[jobIdx][0];
//                }
//            } else {
//                int[] job = pq.poll();
//                currentTime += job[1];
//                totalWaitTime += currentTime - job[0];
//            }
//        }

//        while(jobIdx < jobs.length || !pq.isEmpty()) {
//            // 도착한 작업들 추가
//            while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
//                pq.offer(jobs[jobIdx]);
//                jobIdx++;
//            }
//
//            if(pq.isEmpty()) {
//                // 처리할 게 없으면 다음 작업까지 점프
//                currentTime = jobs[jobIdx][0];
//            } else {
//                int[] job = pq.poll();
//                currentTime += job[1];
//                totalWaitTime += currentTime - job[0];
//            }
//        }

        return totalWaitTime/jobs.length;


//
//        while (!pq.isEmpty()){
//            int[] job = pq.poll();
//            currentTime += currentTime+job[1] - job[0];
//            //totalWaitTime += currentTime - job[0];
//        }

//        return currentTime/jobs.length;
    }
    public static void main(String[] arr){


        int[][] workTime = {{0,3},{1,9},{500,6}};
        int result = solution(workTime);
        System.out.println(result);

    }

}
