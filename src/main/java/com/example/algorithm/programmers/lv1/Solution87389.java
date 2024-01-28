package com.example.algorithm.programmers.lv1;

public class Solution87389 {
    // n : 10
    // answer : 3
    public int solution(int n) {
        int answer = 1;

        while(true) {
            if (n % answer == 1) break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10;

        Solution87389 solution87389 = new Solution87389();
        System.out.println(solution87389.solution(n));
    }
}
