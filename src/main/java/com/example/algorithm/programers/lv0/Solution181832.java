package com.example.algorithm.programers.lv0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution181832 {
    // n : 4
    // result : [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
    // 123 45 67 8 9
    // 00 01 02 03 - 13 23 33 - 32 31 30 - 20 10 - 11 12 - 22 - 21
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> nSquare = new LinkedList<>();
        int loop = 0;

        for (int k = 1; k <= n * n; k++) {
            nSquare.add(k);
        }

        // j ++ -> i++ -> j-- -> i--
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 인덱스 범위 및 다음 위치 좌표로 조정
        int[][] adjust = {{1, -1}, {-1, -1}, {-1 ,1} , {1, 1}};
        int i = 0, j = 0, idx = 0;

        while (loop < n * n) {
            while (i >= 0 && i < n && j >= 0 && j < n && !visited[i][j]) {
                answer[i][j] = nSquare.poll();
                visited[i][j] = true;
                i = i + move[idx][0];
                j = j + move[idx][1];
                loop++;
            }

            i = i + adjust[idx][0];
            j = j + adjust[idx][1];

            if (idx == move.length - 1) {
                idx = 0;
            } else {
                idx++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution181832 solution181832 = new Solution181832();
        int[][] solution = solution181832.solution(n);
        System.out.println(Arrays.deepToString(solution));
    }
}
