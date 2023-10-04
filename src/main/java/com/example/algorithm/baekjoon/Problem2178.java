package com.example.algorithm.baekjoon;

import java.util.Scanner;

public class Problem2178 {
    public static void main(String[] args) {
        input();
        // bfs
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 입력으로 정수 2개를 받음
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 다음 줄을 읽어서 개행 문자 제거
        scanner.nextLine();

        // 이진 문자열을 저장할 배열을 생성
        char[][] graph = new char[n][m];

        // n개의 이진 문자열을 입력받음
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
    }
}
