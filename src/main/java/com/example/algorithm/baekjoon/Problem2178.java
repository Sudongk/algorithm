package com.example.algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2178 {

    static boolean[][] map;
    static boolean[][] visit;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        input();

        // bfs
        System.out.println(bfs(0, 0));
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 입력으로 정수 2개를 받음
        n = sc.nextInt();
        m = sc.nextInt();

        // 다음 줄을 읽어서 개행 문자 제거
        sc.nextLine();

        map = new boolean[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }
    }

    private static int bfs(int x, int y) {
        visit[x][y] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(x, y, 1));

        while (!q.isEmpty()) {
            Coordinate c = q.remove();

            if (c.x == n - 1 && c.y == m - 1)
                return c.c;

            for (int i = 0; i < 4; i++) {
                int nowX = c.x + dx[i];
                int nowY = c.y + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (!visit[nowX][nowY] && map[nowX][nowY]) {
                        visit[nowX][nowY] = true;
                        q.add(new Coordinate(nowX, nowY, c.c + 1));
                    }
                }
            }
        }

        return 0;
    }

    static class Coordinate {
        int x;
        int y;
        int c;

        public Coordinate(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

}
