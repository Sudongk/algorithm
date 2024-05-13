package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution86971 {

    // n : 9
    // wires : [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
    // return : 3

    // 반례
    // n :9
    // wires: [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9]]
    // return : 1

    public int solution(int n, int[][] wires) {
        int answer = 999999999;

        // 0번 인덱스는 사용하지 않음
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트 생성
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
            System.out.println(graph);
        }

        // 각 간선을 제거하고 bfs로 탐색
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 간선 제거
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            int aCount = bfs(graph, v1, n);
            int bCount = bfs(graph, v2, n);

            int diff = Math.abs(aCount - bCount);

            answer = Math.min(answer, diff);

            // 제거한 간선 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return answer;
    }

    private int bfs(List<List<Integer>> graph, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 노드와 연결된 노드 탐색
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}};

        Solution86971 solution = new Solution86971();

        int answer = solution.solution(n, wires);

        System.out.println(answer);
    }

}
