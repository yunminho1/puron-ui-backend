package com.puron.backend.sample;

import java.util.ArrayList;
import java.util.List;

public class GreedyTest {

    static class Room{
        int start;
        int end;

        Room(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] arr){
//        N개의 회의가 있고, 각 회의는 (시작시간, 종료시간)이 있다.
//        한 명이 최대한 많은 회의에 참석하려면?
//
//        예:
//        입력: [(1,3), (2,5), (4,6), (6,7), (5,8)]
//        출력: 3 (예: (1,3), (4,6), (6,7))
        List<Room> roomData = new ArrayList<>();
        roomData.add(new Room(1,3));
        roomData.add(new Room(2,5));
        roomData.add(new Room(4,6));
        roomData.add(new Room(6,7));
        roomData.add(new Room(5,8));
        roomData.sort((a,b)->Integer.compare(a.end,b.end));

        List<Room> resultData = new ArrayList<>();
        resultData.add(roomData.getFirst());
        int listTime=roomData.getFirst().end;

        for(int i=1; i<roomData.size();i++) {
            Room courrent = roomData.get(i);
            if(listTime<=courrent.start) {
                resultData.add(new Room(courrent.start,courrent.end));
                listTime=courrent.end;
            }
        }

        for(Room data : resultData){
            System.out.println(data.start+":"+data.end);
        }
    }



}
