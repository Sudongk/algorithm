package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution12909 {

    // s : "()()"
    // return : true

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        char[] array = s.toCharArray();

        // 배열의 처음과 끝에 올바르지 않은 괄호가 있으면 false
        if (array[s.length() - 1] == '(' || array[0] == ')') {
            return false;
        }

        for (char ch : array) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    // 여는 괄호가 없는데 닫는 괄호가 나오면 올바르지 않은 괄호면 false
                    return false;
                }
                // 짝이 맞는 경우 스택에서 여는 괄호를 제거
                stack.pop();
            }
        }

        // 스택에 남아 있는 괄호가 있는 경우에도 올바르지 않은 괄호먄 false
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution12909 solution = new Solution12909();
        String s = "(()()";
        boolean answer = solution.solution(s);
        System.out.println(answer);
    }

}
