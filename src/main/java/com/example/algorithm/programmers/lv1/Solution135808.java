package com.example.algorithm.programers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution135808 {
    // k : 3
    // m : 4
    // score : [1, 2, 3, 1, 2, 3, 1]
    // result : 8
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 오름차순 정렬
        int[] array = Arrays.stream(score).sorted().toArray();

        List<Integer> box = new ArrayList<>(m);

        int idx = array.length - 1;

        while(idx >= 0) {
            box.add(array[idx]);
            idx--;

            // 상자에 m개의 갯수가 담기면 가격 계산 후 상자 초기화
            if (box.size() == m) {
                Integer min = box.get(m - 1);

                answer += min * m;
                box.clear();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        Solution135808 solution135808 = new Solution135808();
        System.out.println(solution135808.solution(k, m, score));
    }
}
