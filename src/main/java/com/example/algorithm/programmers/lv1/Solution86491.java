package com.example.algorithm.programmers.lv1;

import java.util.Arrays;

public class Solution86491 {

    // sizes : [[60, 50], [30, 70], [60, 30], [80, 40]]
    // return : 4000

    public int solution(int[][] sizes) {
        int answer = 0;

        int maxW = 0;
        int maxH = 0;

        // 가로, 세로 중 큰 값을 찾아서 저장
        for (int[] size : sizes) {
            // 오름차순 정렬
            Arrays.sort(size);

            // 최대 가로, 세로 길이 저장
            maxW = Math.max(maxW, size[0]);
            maxH = Math.max(maxH, size[1]);
        }

        answer = maxW * maxH;

        return answer;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        Solution86491 solution = new Solution86491();

        int answer = solution.solution(sizes);

        System.out.println(answer);
    }

}
