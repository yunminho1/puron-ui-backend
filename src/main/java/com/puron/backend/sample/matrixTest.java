package com.puron.backend.sample;

import java.beans.Customizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;

public class matrixTest {
    static class Point {
        int x, y;
        int width, height;

        public Point(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

    }
    public static void main(String[] arr) {

//        입력:
//        matrix = [[1,2,3,4],
//          [5,6,7,8],
//          [9,10,11,12],
//          [13,14,15,16]]
//
//        출력:
//[[13,9,5,1],
// [14,10,6,2],
// [15,11,7,3],
// [16,12,8,4]]
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int maxRow = matrix.length;
        int[][] rotated = new int[maxRow][maxRow];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxRow; j++) {
                rotated[j][maxRow - 1 - i] = matrix[i][j];
            }
        }

        for (int[] num : rotated) {
            for (int val : num) {
                System.out.println(val);
            }
        }


//        입력: s = "abbaca"
//        출력: "ca"
//
//        이유:
//        "abbaca" →
//        - a 추가 [a]
//                - b 추가 [a,b]
//        - b 제거 (중복) [a]
//                - a 제거 (중복) []
//        - c 추가 [c]
//                - a 추가 [c,a]
//        결과: "ca"


        String data = "abbaca";
        Stack<Character> s = new Stack<>();

        for (char d : data.toCharArray()) {
            if (!s.isEmpty() && s.peek() == d) {
                s.pop();
            } else {
                s.push(d);
            }
        }
        System.out.println(s);


//        격자 크기: 3×3 (0~2, 0~2)
//        시작 위치: (0, 0)
//        명령어: "LLURDDR"
//
//        명령어 정의:
//        - L: 왼쪽으로 1칸 (x - 1)
//                - R: 오른쪽으로 1칸 (x + 1)
//                - U: 위로 1칸 (y + 1)
//                - D: 아래로 1칸 (y - 1)
//
//        경계 밖이면 그 명령어는 무시!
//
//                최종 위치: (?, ?)

//        int[][] ph = {
//                {0,1,2},
//                {0,1,2},
//                {0,1,2}
//        };
//        String message = "LLURDDR";
//        Map<String, Consumer<Point>> direction = new HashMap<>();
//        direction.put("L", p -> {
//            int nx = p.x - 1;
//            if (nx >= 0 && nx < p.width) p.x = nx;
//        });
//        direction.put("R", p -> {
//            int nx = p.x + 1;
//            if (nx >= 0 && nx < p.width) p.x = nx;
//        });
//        direction.put("U", p -> {
//            int ny = p.y + 1;
//            if (ny >= 0 && ny < p.height) p.y = ny;
//        });
//        direction.put("D", p -> {
//            int ny = p.y - 1;
//            if (ny >= 0 && ny < p.height) p.y = ny;
//        });
//
//
//        Point current = new Point(0,0,3,3);
//
//        for(char msg : message.toCharArray()){
//            direction.get(msg+"").accept(current);
//        }
//        System.out.println(current.x+"+"+current.y);
//        int[] pos = {0, 0};
//        int width = 3, height = 3;
//
//// Consumer 사용 (return 없음)
//        Map<String, Consumer<int[]>> direction = new HashMap<>();
//
//        direction.put("L", p -> {
//            int nx = p[0] - 1;
//            if(nx >= 0 && nx < width) p[0] = nx;
//        });
//
//        direction.put("R", p -> {
//            int nx = p[0] + 1;
//            if(nx >= 0 && nx < width) p[0] = nx;
//        });
//
//        direction.put("U", p -> {
//            int ny = p[1] + 1;
//            if(ny >= 0 && ny < height) p[1] = ny;
//        });
//
//        direction.put("D", p -> {
//            int ny = p[1] - 1;
//            if(ny >= 0 && ny < height) p[1] = ny;
//        });
//
//        String message = "LLURDDR";
//
//        for(char msg : message.toCharArray()){
//            direction.get(msg+"").accept(pos);  // 배열 직접 수정!
//        }
//
//        System.out.println(pos[0] + ":" + pos[1]);




        int[][] ph = {
                {0, 1, 2},
                {0, 1, 2},
                {0, 1, 2}
        };
        String message = "LLURDDR";
        int[] pos = {0,0};
        int width3=3,height=3;
        Map<String, Consumer<int[]>> direction = new HashMap<>();
        direction.put("L",(dArr)->{
            int nx = dArr[0]-1;
            if(nx>=0&&nx<width3) dArr[0]=nx;
        });
        direction.put("R",(dArr)->{
            int nx = dArr[0]+1;
            if(nx>=0&&nx<width3) dArr[0]=nx;
        });
        direction.put("U",(dArr)->{
            int ny = dArr[1]+1;
            if(ny>=0&&ny<width3) dArr[1]=ny;
        });
        direction.put("D",(dArr)->{
            int ny = dArr[1]-1;
            if(ny>=0&&ny<width3) dArr[1]=ny;
        });

        for(char msg : message.toCharArray()){
            direction.get(msg+"").accept(pos);
        }

        System.out.println("robot : "+pos[0]+"-"+pos[1]);






        int x = 0;
        int y = 0;
        int width = 3;
        int heigth = 3;

        for (char msg : message.toCharArray()) {
            int nx = x, ny = y;
            if (msg == 'L') {
                nx = nx - 1;
            } else if ("R".equals(msg + "")) {
                nx = nx + 1;
            } else if ("U".equals(msg + "")) {
                ny = ny + 1;
            } else if ("D".equals(msg + "")) {
                ny = ny - 1;
            }
            if ((nx >= 0 && nx < width)
                    && (ny >= 0 && ny < heigth)) {
                x = nx;
                y = ny;
            }
        }
        System.out.println(x + ":" + y);
    }
}
