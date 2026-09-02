package com.puron.backend.deepening;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    //        난이도: Level 2
//
//        수를 입력받아 해당 수만큼의 쌍으로 이루어진 괄호의 모든 올바른 조합을 구하시오.
//
//                입출력 예:
//
//        입력: n = 3
//        출력: ["((()))","(()())","(())()","()(())","()()()"]
//
//        제약조건:
//
//        n은 1 이상 10 이하이다.

    static List<String> result = new ArrayList<>();

    static List<String> solution(int n) {
        dfs(n, 0, 0, "");
        return result;
    }

    // open: 아직 닫아야 할 '(' 개수
    // close: 닫은 ')' 개수
    static void dfs(int n, int open, int close, String current) {
        // 완성
        if(close == n) {
            result.add(current);
            return;
        }

        // 아직 '('를 열 수 있으면 열기
        if(open < n) {
            dfs(n, open + 1, close, current + "(");
        }

        // 닫을 '('가 남아있으면 닫기
        if(close < open) {
            dfs(n, open, close + 1, current + ")");
        }
    }

    public static void main(String[] args) {

        List<String> result = solution(1);
        for(String s : result) {
            System.out.println(s);
        }
        // 출력:
        // ((()))
        // (()())
        // (())()
        // ()(())
        // ()()()
    }
}
