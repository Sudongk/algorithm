package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42584 {

    // prices : [1, 2, 3, 2, 3]
    // return : [4, 3, 1, 1, 0]

    public int[] solution(int[] prices) {
        int[] answer = {};

        // prices 배열의 길이만큼 answer 배열 생성
        answer = new int[prices.length];

        // prices 배열의 길이만큼 반복
        for (int i = 0; i < prices.length; i++) {
            // 현재 가격과 비교할 가격
            int currentPrice = prices[i];
            int count = 0;
            // 현재 가격과 비교할 가격의 차이가 0보다 크고 현재 가격의 인덱스가 prices 배열의 길이보다 작다면 반복
            for (int j = i + 1; j < prices.length; j++) {
                // 현재 가격과 비교할 가격의 차이가 0보다 크다면 count 증가
                if (currentPrice <= prices[j]) {
                    count++;
                } else {
                    // 현재 가격과 비교할 가격의 차이가 0보다 작다면 count 증가 후 반복문 종료
                    count++;
                    break;
                }
            }
            // 현재 가격의 인덱스에 count를 저장
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution42584 solution = new Solution42584();
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution.solution(prices);
        System.out.println(Arrays.toString(answer));
    }

}
