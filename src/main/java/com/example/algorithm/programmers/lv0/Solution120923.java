package com.example.algorithm.programmers.lv0;

import java.util.Arrays;

public class Solution120923 {
    // num : 3
    // total : 12
    // result : [3, 4, 5]
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        // 시작값이 total값의 중간값에서 살짝 작은값이 되도록 설정
        int start = (total / num) - ((num - 1) / 2);

        for(int i = 0; i < num; i++) {
            answer[i] = start;
            start++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int num = 5;
        int total = 15;
        Solution120923 solution120923 = new Solution120923();
        System.out.println(Arrays.toString(solution120923.solution(num, total)));
    }
}
