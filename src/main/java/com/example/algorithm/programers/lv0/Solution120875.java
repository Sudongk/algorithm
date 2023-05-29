package com.example.algorithm.programers.lv0;

public class Solution120875 {
    // dots : [[1, 4], [9, 2], [3, 8], [11, 6]]
    // result : 1

    public int solution(int[][] dots) {
        int answer = 0;

        // 각각의 점을 a,b,c,d라고 했을 떼 가능한 경우의 수는 a-b/c-d, a-c/b-d, a-d/b-c
        int[][] cases = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
        for (int i = 0; i < cases.length; i++) {
            int a = cases[i][0];
            int b = cases[i][1];
            int c = cases[i][2];
            int d = cases[i][3];

            double line1_incline = (double) (dots[b][1] - dots[a][1]) / (dots[b][0] - dots[a][0]);
            double line2_incline = (double) (dots[d][1] - dots[c][1]) / (dots[d][0] - dots[c][0]);

            if (line1_incline == line2_incline) {
                answer = 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        Solution120875 solution120875 = new Solution120875();
        int solution = solution120875.solution(dots);
        System.out.println(solution);
    }
}
