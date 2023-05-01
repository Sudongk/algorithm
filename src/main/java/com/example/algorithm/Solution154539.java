package com.example.algorithm;

public class Solution154539 {
    // numbers : [2, 3, 3, 5]
    // result : [3, 5, 5, -1]
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                answer[len - 1] = -1;
                break;
            }

            int curVal = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                int nextVal = numbers[j];

                if (nextVal > curVal) {
                    answer[i] = nextVal;
                    break;
                }

                answer[i] = -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        Solution154539 solution154539 = new Solution154539();
        int[] solution = solution154539.solution(numbers);
        for (int s : solution) {
            System.out.println(s);
        }
    }
}
