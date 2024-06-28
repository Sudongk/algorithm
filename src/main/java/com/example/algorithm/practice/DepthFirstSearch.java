package com.example.algorithm.practice;

public class DepthFirstSearch {

    /*
     * 깊이 우선 탐색 풀이 방식 (Depth First Search)
     * 1. 시작 정점을 스택에 넣는다.
     * 2. 스택에서 정점을 꺼내 방문한다.
     * 3. 방문한 정점에서 인접한 정점 중 방문하지 않은 정점을 스택에 넣는다.
     * 4. 스택이 빌 때까지 2~3을 반복한다.
     *
     * 깊이 우선 탐색이 필요한 경우 대표 3 가지
     * 1. 그래프의 모든 정점을 방문하는 경우
     * 2. 그래프의 연결 요소를 찾는 경우
     * 3. 그래프의 사이클을 찾는 경우
     */

    public void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}
        };

        boolean[] visited = new boolean[graph.length];

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(graph, visited, 0);
    }

}
