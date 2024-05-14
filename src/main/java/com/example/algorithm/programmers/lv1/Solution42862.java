package com.example.algorithm.programmers.lv1;

import java.util.*;

public class Solution42862 {

    // n : 5
    // lost : [2, 4]
    // reserve : [1, 3, 5]
    // return : 5

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        // 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가지고 있지만 도난 당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        // 여벌 체육복을 빌려줄 수 있는 경우
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) {
                    continue;
                }

                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 3, 4};
        int[] reserve = {3, 4, 5};

        Solution42862 solution = new Solution42862();

        int answer = solution.solution(n, lost, reserve);

        System.out.println(answer);
    }

}
