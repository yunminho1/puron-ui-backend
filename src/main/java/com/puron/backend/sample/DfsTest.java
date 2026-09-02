package com.puron.backend.sample;

import java.util.ArrayList;
import java.util.List;

public class DfsTest {
    static boolean[] visited;
    static void dfs(int node,List<Integer>[] dataList){
        visited[node] = true;
        System.out.println(node+"");

        for(int next : dataList[node]){
            if(!visited[next]){
                dfs(next,dataList);
            }
        }
    }

    public static void main(String[] arr){
        List<Integer>[] intList = new ArrayList[5];
        for(int i=0; i<5; i++){
            intList[i] = new ArrayList<>();
        }

        intList[0].add(1);//[1]
        intList[0].add(2);//[1,1]
        intList[1].add(3);//[2]
        intList[2].add(4);//[3]

        visited = new boolean[5];
        dfs(0,intList);

    }
}
