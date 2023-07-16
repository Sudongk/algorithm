package com.example.algorithm.programers.lv2;

public class Solution181187 {
    // r1 : 2
    // r2 : 3
    // result : 20
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 0; i <= r2; i++) {
            for (int j = 0; j <= r2; j++) {
                double d = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
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

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        Solution181187 solution181187 = new Solution181187();
        System.out.println(solution181187.solution(r1, r2));
    }
}
