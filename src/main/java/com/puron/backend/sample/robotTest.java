package com.puron.backend.sample;

public class robotTest {

    public static void main(String[] arr){
        int[][] grid = new int[5][5];
        int x=1,y=1;
        int direction = 0;  // 0=북(위), 1=동(오른쪽), 2=남(아래), 3=서(왼쪽)

        // 3. 방향 벡터 (상, 우, 하, 좌)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //청소된 칸수
        int cleanedCount = 0;

        for (int step = 0; step < 100; step++) {
            //현재 청소여부 확인
            if(grid[x][y]==0){
                grid[x][y] = 1;
                cleanedCount++;
                System.out.println("(" + x + ", " + y + ") 청소 완료. 총 " + cleanedCount + "칸");
            }

            //왼쪽으로


            // 왼쪽 방향 확인 (시계 반대방향)
            int leftDir = (direction + 3) % 4;
            int leftX = x + dx[leftDir];
            int leftY = y + dy[leftDir];

            // 왼쪽이 범위 안이고 청소 안 했으면 회전해서 이동
            if (leftX >= 0 && leftX < 5 && leftY >= 0 && leftY < 5 && grid[leftX][leftY] == 0) {
                direction = leftDir;
                x = leftX;
                y = leftY;
                System.out.println("왼쪽으로 회전하여 (" + x + ", " + y + ")로 이동");
            } else {
                // 아니면 시계방향 회전
                direction = (direction + 1) % 4;
                System.out.println("시계방향 회전. 현재 방향: " + direction);
            }
        }
    }
}
