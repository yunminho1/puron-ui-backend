package com.puron.backend.sample;

import java.util.*;

public class WordLadder {

    // 두 단어가 정확히 한 글자만 다른지 확인
    static boolean isOneLetterDiff(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int diffCount = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if(diffCount > 1) return false;
            }
        }
        return diffCount == 1;
    }

    // BFS로 최단 경로 찾기
    static int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        if(!wordSet.contains(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(begin);
        visited.add(begin);

        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for(int i = 0; i < size; i++) {
                String current = queue.poll();

                for(String word : words) {
                    if(visited.contains(word)) continue;

                    if(isOneLetterDiff(current, word)) {
                        if(word.equals(target)) {
                            return distance;
                        }

                        visited.add(word);
                        queue.add(word);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};

        int result = solution(begin, target, words);
        System.out.println("결과: " + result);  // 출력: 5


        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        List<Integer> setNum = new LinkedList<>();
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(computers[i][j]==1 && i!=j){
                    setNum.add(i);
                }
            }
        }
        System.out.println(setNum.size());
    }
}