package com.example.algorithm.practice;

public class BreadthFirstSearch {

    /*
     * 너비 우선 탐색 풀이 방식 (Breadth First Search)
     * 1. 시작 정점을 큐에 넣는다.
     * 2. 큐에서 정점을 꺼내 방문한다.
     * 3. 방문한 정점에서 인접한 정점 중 방문하지 않은 정점을 큐에 넣는다.
     * 4. 큐가 빌 때까지 2~3을 반복한다.
     *
     * 너비 우선 탐색이 필요한 경우 대표 3 가지
     * 1. 최단 경로를 찾는 경우
     * 2. 임의의 경로를 찾는 경우
     * 3. 모든 정점을 방문하는 경우
     */

    public void bfs(int[][] graph, boolean[] visited, int start) {
        int[] queue = new int[graph.length];
        int front = 0;
        int rear = 0;

        queue[rear++] = start;
        visited[start] = true;

        while (front < rear) {
            int current = queue[front++];
            System.out.print(current + " ");

            for (int i = 0; i < graph[current].length; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    queue[rear++] = i;
                    visited[i] = true;
                }
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

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.bfs(graph, visited, 0);
    }

}
