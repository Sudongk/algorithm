package com.example.algorithm.programers;

import java.util.*;
import java.util.stream.Collectors;

/*
* UnsupportedOperationException 에러는 보통 List 형을 new로 초기화하지 않는 상태에서 Arrays.asList로 생성하였을 시 주로 발생한다.
* ConcurrentModificationException 에러는 보통 리스트나 Map 등, Iterable 객체를 순회하면서 요소를 삭제하거나 변경을 할 때 발생
*/
public class Solution178871 {
    // players : ["mumu", "soe", "poe", "kai", "mine"]
    // callings : ["kai", "kai", "mine", "mine"]
    // result : ["mumu", "kai", "mine", "soe", "poe"]
    public static String[] solution(String[] players, String[] callings) {
        int n = players.length;
        String[] answer = new String[n];
        // 순위
        Map<String, Integer> rank = new HashMap<>();

        // 기본 순위 할당
        for(int i = 0; i < n; i++) {
            rank.put(players[i], i);
        }

        // 순위 변경 호명
        for(String call : callings) {
            // prev = 이전 순위, cur = 바뀔 순위
            int prev = rank.get(call), cur = prev - 1;
            // curPlayer = 바뀔 순위에 위치해있던 선수
            String curPlayer = players[cur];

            // swap 처리
            players[prev] = curPlayer;
            players[cur] = call;
            rank.put(curPlayer, prev);
            rank.put(call, cur);
        }
        // 결과 할당
        for(var entry : rank.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        };

        return answer;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] solution = solution(players, callings);
        for (String s : solution) {
            System.out.println(s);
        }
    }

}
