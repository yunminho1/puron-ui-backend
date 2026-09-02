package com.puron.backend.sample;

import java.util.*;

public class BfsTest {

    static Set<String> visited = new HashSet<>();
    static List<String> resultList = new ArrayList<>();
    static void dfs( String current, Map<String, List<String>> graph){
        visited.add(current);
        resultList.add(current);
        for(String neighbor : graph.get(current)){
            if(!visited.contains(neighbor)){
                dfs(neighbor,graph);
            }
        }
    }

    public static void main(String[] arr){
//        배송소: A, B, C, D, E
//        연결 관계:
//        A - B
//        A - C
//        B - D
//        C - D
//
//        질문:
//        1. A에서 D로 갈 수 있나? → YES (A→B→D 또는 A→C→D)
//        2. B에서 C로 갈 수 있나? → YES (B→A→C)
//        3. D에서 E로 갈 수 있나? → NO (E는 고립됨)

        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B","C"));
        graph.put("B", Arrays.asList("A","D"));
        graph.put("C", Arrays.asList("A","D"));
        graph.put("D", Arrays.asList("B","C"));
        graph.put("E", new ArrayList<>());

        Map<String, List<String>> allDataMap = new HashMap<>();
        List<String> message = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));

        for (String key : graph.keySet()) {
            visited = new HashSet<>();
            resultList = new ArrayList<>();
            dfs(key, graph);
            allDataMap.put(key, resultList);
        }

        System.out.println("A->D : "+allDataMap.get("A").contains("D"));
        System.out.println("A->B : "+allDataMap.get("A").contains("B"));
        System.out.println("B->C : "+allDataMap.get("B").contains("C"));
        System.out.println("B->D : "+allDataMap.get("D").contains("E"));

        //여기서 allDataMap 에 서는 A가 갈수 있는 모든 것이 담겨있으니 value에 존재하는지 만 찾으면 됨

    }

}
