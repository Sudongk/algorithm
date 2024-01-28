package com.example.algorithm.programers.lv1;


public class Solution134240 {
    // food : [1, 3, 4, 6]
    // result : "1223330333221"
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i >= 0; i--) {
            int tempVal = food[i];
            int idx = i;

            // 음식 개수가 홀수라면 하나 버림
            if (food[i] % 2 != 0) {
                tempVal--;
            }

            if (tempVal == 0) {
                continue;
            }

            // 음식 개수의 절반만큼 반복하여 문자 앞뒤 동시에 추가
            for (int j = 1; j <= tempVal / 2; j++) {
                answer = answer + idx;
                answer = idx + answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        Solution134240 solution134240 = new Solution134240();
        String solution = solution134240.solution(food);

        System.out.println(solution);
    }
}
