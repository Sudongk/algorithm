package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution86971 {

    // n : 9
    // wires : [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
    // return : 3

    public int solution(int n, int[][] wires) {
        int answer = 999999999;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            Set<Integer> set1 = map.get(v1);
            Set<Integer> set2 = map.get(v2);

//            set1.add(v1);
            set1.add(v2);
            set2.add(v1);
//            set2.add(v2);

            map.put(v1, set1);
            map.put(v2, set2);
        }

        System.out.println(map);

        for (int[] wire : wires) {
            int count1 = countConnectedTower(map, wire[0], wire[1]);
            int count2 = countConnectedTower(map, wire[1], wire[0]);;

            int diffCount = Math.abs(count1 - count2);

            if (diffCount < answer) {
                answer = diffCount;
            }
        }

        return answer;
    }

    public int countConnectedTower(Map<Integer, Set<Integer>> map, int targetNode, int excludeNode) {
        Set<Integer> connectNode = new HashSet<>();
        Set<Integer> nodes = map.get(targetNode);

        for (int key : nodes) {
            if (key == excludeNode) {
                continue;
            }

            connectNode.addAll(map.get(key));
        }

        return connectNode.size() + 1;
    }


    public static void main(String[] args) {
        // 반례
        // 9, [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9]]
        // 1
        int n = 9;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}};

        Solution86971 solution = new Solution86971();

        int answer = solution.solution(n, wires);

        System.out.println(answer);
    }

}
