package com.example.algorithm.programmers.lv1;

public class Solution136798 {
    // number : 5
    // limit : 3
    // power : 2
    // result : 10
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 0; i < number; i++) {
            int divisor = divisor(i + 1);

            if (divisor > limit) {
                answer += power;
                continue;
            }

            answer += divisor;
        }

        return answer;
    }

    private static int divisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if(i * i == num) count++;
                else count += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        Solution136798 solution136798 = new Solution136798();
        System.out.println(solution136798.solution(number, limit, power));
    }
}
