package com.example.algorithm.programmers.lv0;

public class Solution120866 {
    // board : [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]
    // result : 16
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    visited[i][j] = true;
                    checkSafetyZone(i, j, visited, board);
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (!visited[i][j]) {
                    answer += 1;
                }
            }
        }
        return answer;
    }

    // 2차원 배열 visited 를 이용하여 안전 지역이 아닌 지역 갱신
    public static void checkSafetyZone(int i, int j, boolean[][] visited, int[][] board) {
        // 양쪽 대각선/좌/우/위/아래
        int[] mi = {-1, 1, -1, 1, 0, 0, 1, -1};
        int[] mj = {-1, 1, 1, -1, -1, 1, 0, 0};
        for (int k = 0; k < mi.length; k++) {
            int ni = i + mi[k];
            int nj = j + mj[k];
            if (checkOutOfIdx(ni, nj, board)) {
                if (!visited[ni][nj]) {
                    visited[ni][nj] = true;
                }
            }
        }
    }

    // 범위 체크
    public static boolean checkOutOfIdx(int ni, int nj, int[][] board) {
        return ni < board.length && ni >= 0 && nj < board[ni].length && nj >= 0;
    }

    public static void main(String[] args) {
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        Solution120866 solution120866 = new Solution120866();
        System.out.println(solution120866.solution(board));
    }
}


