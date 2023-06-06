package com.example.algorithm.programers.lv0;

import java.util.Arrays;

public class Solution181893 {
    // arr : [0, 1, 2, 3, 4, 5]
    // query : [4, 1, 2]
    // result : [1, 2, 3]
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};

        int start = 0, end = 0;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 != 0) {
                start = start + query[i];
            }

            if (i % 2 == 0) {
                end = start + query[i];
            }
        }

        // 배열 부분 복사
        answer = Arrays.copyOfRange(arr, start, end + 1);

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        Solution181893 solution181893 = new Solution181893();
        System.out.println(Arrays.toString(solution181893.solution(arr, query)));
    }
}
