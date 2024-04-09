package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42746 {

    // numbers : [6, 10, 2]
    // return : "6210"

    public String solution(int[] numbers) {
        // Integer 배열을 String 배열로 변환
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 정렬 기준 설정
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        System.out.println(Arrays.toString(nums));

        // 모든 수가 0인 경우 예외 처리
        if (nums[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 이어붙여 결과 반환
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9, 3, 30, 34, 5, 9,34, 5, 934, 5, 9};

        Solution42746 solution = new Solution42746();

        String answer = solution.solution(numbers);

        System.out.println(answer);
    }

}
