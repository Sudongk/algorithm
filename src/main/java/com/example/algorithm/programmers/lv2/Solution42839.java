package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42839 {

    // numbers : "17"
    // return : 3

    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        // 순열을 이용하여 모든 경우의 수를 구함
        permutation("", numbers, set);

        // 소수 판별
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 순열
    private void permutation(String prefix, String numbers, Set<Integer> set) {
        int n = numbers.length();

        if (!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }

        for (int i = 0; i < n; i++) {
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1, n), set);
        }
    }

    public static void main(String[] args) {
        String numbers = "011";

        Solution42839 solution = new Solution42839();

        int answer = solution.solution(numbers);

        System.out.println(answer);
    }

}
