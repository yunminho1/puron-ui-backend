package com.puron.backend.sample;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BfsTest3 {
    public static void main(String[] arr){
        int[][] graph = {
            {1, 2},      // 0의 이웃: 1, 2
            {0, 3},      // 1의 이웃: 0, 3
            {0},         // 2의 이웃: 0
            {5}          // 3의 이웃: 1
        };
        int result = bfs(5,3,graph);
        System.out.println(result);
    }

    static int bfs(int start,int end,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(start);
        visited.add(start);
        int distance = 0;

        while (!q.isEmpty()){
            int size = q.size();
            distance++;

            for(int i=0;i<size;i++){
                int cur = q.poll();
                if(end==cur){
                    return distance;
                }
                for(int d : graph[cur]){
                    if(!visited.contains(d)){
                        visited.add(d);
                        if(d>=0 && d<graph.length){
                            q.add(d);
                        }
                    }
                }

            }
        }

        return -1;
    }
}
