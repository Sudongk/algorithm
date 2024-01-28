package com.example.algorithm.programmers.lv2;

public class Solution181187 {
    // r1 : 2
    // r2 : 3
    // result : 20
    public long solution(int r1, int r2) {
        long answer = 0;

        // 큰 원에 있는 모든 정수의 원점과 길이가 작은 원의 반지름보다 크거나 같고,
        // 큰 원의 반지름보다 작거나 같은 모든 정수 count
        // 정답은 맞지만 시간초과...개선 필요
        for (int i = 0; i <= r2; i++) {
            for (int j = 0; j <= r2; j++) {
                double d = distance(i, j);
                if (d <= (double) r2) {
                    if (d >= (double) r1) {
                        if (i == 0 || j == 0) {
                            answer = answer + 2;
                        } else {
                            answer = answer + 4;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private double distance(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        Solution181187 solution181187 = new Solution181187();
        System.out.println(solution181187.solution(r1, r2));
    }
}