package com.puron.backend.sample;

import java.util.*;
import java.util.stream.Collectors;

public class BfsTest2 {
    static Set<String> visited = new HashSet<>();
    static List<String>visitList = new ArrayList<>();

    static void dfc(String current , Map<String,List<String>> graph){
        visited.add(current);
        visitList.add(current);
        for(String visitData : graph.getOrDefault(current,new ArrayList<>())){
            if(!visited.contains(visitData)){
                dfc(visitData,graph);
            }
        }
    }
    static Map<Integer, Long> memo = new HashMap<>();

    static long fibonacci(int n) {
        // 기저 조건
        if (n == 1 || n == 2) return 1;

        // 이미 계산했으면 반환
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 아직 계산 안 했으면 계산 후 저장
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] arr){
//        그래프:
//        1 - 2
//        2 - 4
//        4 - 3
//        (1, 2, 3, 4는 하나의 컴포넌트)
//
//        5 - 6
//        (5, 6은 별도의 컴포넌트)
//
//        7
//        (7은 단독)
//
//        8 - 9
//        9 - 10
//        (8, 9, 10은 한 컴포넌트)

        Map<String, List<String>> graph = new HashMap<>();
        graph.put("1",List.of("2"));
        graph.put("2",List.of("1","4"));
        graph.put("3",List.of("2","4"));
        graph.put("4",List.of("2","3"));
        graph.put("5",List.of("6"));
        graph.put("6",List.of("5"));
        graph.put("7",new ArrayList<>());
        graph.put("8",List.of("9"));
        graph.put("9",List.of("8","10"));
        graph.put("10",List.of("9"));  // ← 이거 추가!
        Map<String, List<String>> allVisitMap = new HashMap<>();
        for(String key : graph.keySet()){
            visited = new HashSet<>();
            visitList = new ArrayList<>();
            dfc(key,graph);
            visitList.sort((a, b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
            allVisitMap.put(key, visitList);
        }

        List<List<String>> uniqueValues = allVisitMap.values().stream()
                .distinct() // 중복된 리스트를 제거 (내부 요소와 순서가 같으면 하나만 남김)
                .toList();

        for (int i = 0; i < uniqueValues.size(); i++) {
            System.out.println("그룹" + (i + 1) + ":" + uniqueValues.get(i));
        }

        System.out.println("F(10) = " + fibonacci(10));
        System.out.println("F(20) = " + fibonacci(20));
        System.out.println("F(50) = " + fibonacci(50));

    }
}
