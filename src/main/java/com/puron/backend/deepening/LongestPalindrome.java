package com.puron.backend.deepening;

public class LongestPalindrome {

    // 팰린드롬 확인
    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;  // 하나라도 다르면 false
            }
            left++;
            right--;
        }

        return true;  // 루프 끝까지 다 같으면 true
    }

    // 가장 긴 팰린드롬 찾기
    static String solution(String s) {
        int n = s.length();

        // 앞에서부터 start
        for(int start = 0; start < n; start++) {
            // 뒤에서부터 end로 줄여가면서
            for(int end = n - 1; end >= start; end--) {
                // start부터 end까지의 부분 문자열
                String sub = s.substring(start, end + 1);

                // 팰린드롬인가?
                if(isPalindrome(sub)) {
                    return sub;  // 가장 긴 것부터 반환
                }
            }
        }

        return "";  // 팰린드롬 없으면 빈 문자열
    }

    public static void main(String[] args) {
        // 테스트 1
        String s1 = "babad";
        String result1 = solution(s1);
        System.out.println("입력: " + s1);
        System.out.println("출력: " + result1);
        System.out.println();

        // 테스트 2
        String s2 = "cbbd";
        String result2 = solution(s2);
        System.out.println("입력: " + s2);
        System.out.println("출력: " + result2);
        System.out.println();

        // 테스트 3
        String s3 = "racecar";
        String result3 = solution(s3);
        System.out.println("입력: " + s3);
        System.out.println("출력: " + result3);
        System.out.println();

        // 테스트 4
        String s4 = "a";
        String result4 = solution(s4);
        System.out.println("입력: " + s4);
        System.out.println("출력: " + result4);
    }
}
