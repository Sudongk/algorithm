package com.example.algorithm;

import java.util.Stack;

public class Solution154539 {
    // numbers : [2, 3, 3, 5]
    // result : [3, 5, 5, -1]
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 스택 자료구조를 사용한 풀이...
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }

        for (int i = 0 ; i < answer.length ; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        Solution154539 solution154539 = new Solution154539();
        int[] solution = solution154539.solution(numbers);
        for (int s : solution) {
            System.out.println(s);
        }
    }
}
