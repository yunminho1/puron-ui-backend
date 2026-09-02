package com.puron.backend.deepening;

import java.util.*;

public class WordLadder {
//    문제: 단어 변환
//    문제 설명
//
//    두 개의 단어 begin, target과 단어의 집합 words가 주어진다. 다음 규칙을 따라 begin에서 target으로 변환하는 과정을 찾으려고 한다.
//
//    한 번에 한 개의 알파벳만 바꿀 수 있다.
//    words에 있는 단어로만 변환할 수 있다.
//
//    변환 과정에서 사용하는 단어의 개수의 최솟값을 구하시오. 변환할 수 없으면 0을 반환한다.
//
//    입출력 예
//    begin	target	words	출력
//      "hit"	"cog"	["hot","dot","dog","lot","log","cog"]	5
//        "hit"	"cog"	["hot","dot","dog","lot","log"]	0
//        "hot"	"dot"	["hot","dot","dog"]	2
//        "cold"	"warm"	["cold","cord","card","ward","warm","warn"]	4
//    제약조건
//    begin, target, words의 단어는 모두 소문자로 이루어져 있다.
//    단어의 길이는 3 이상 10 이하이다.
//    words의 개수는 1개 이상 50개 이하이다.
    static int solution(String start, String end, String[] texts){
        int result =0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        visited.add(start);
        q.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            result++;
            for(int i = 0; i < size; i++){
                String qt = q.poll();

                if(qt.equals(end)){
                    return result;
                }

                for(String text : texts){
                    if(visited.contains(text)){
                        continue;
                    }
                    if(isDifferentByOne(qt,text)){
                        q.add(text);
                        visited.add(text);
                    }
                }
            }

        }
    return -1;
    }

    // 두 단어가 정확히 1글자만 다른지 확인
    static boolean isDifferentByOne(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int differenceCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differenceCount++;
            }
        }

        return differenceCount == 1;
    }

    public static void main(String[] arr){
        System.out.println(solution("hit","cot",new String[]{"hot", "aog", "bog", "dog", "cot", "log", "fog"}));

    }
}
