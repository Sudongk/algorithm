package com.example.algorithm.programmers.lv2;

public class Solution43165 {
    // numbers : [1, 1, 1, 1, 1]
    // target : 3
    // result : 5

    // 결과값 저장
    private static int cnt = 0;

    // numbers 배열의 모든 경우의 수를 탐색하여 target과 일치하는 경우의 수를 구함
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }

    // 깊이 우선 탐색
    private void dfs(int[] numbers, int target, int sum, int depth) {
        // numbers 배열의 모든 원소를 탐색한 경우
        if (depth == numbers.length) {
            // target과 일치하는 경우의 수를 증가
            if (sum == target) {
                cnt++;
            }

            // 종료
            return;
        }

        dfs(numbers, target, sum + numbers[depth], depth + 1);
        dfs(numbers, target, sum - numbers[depth], depth + 1);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Solution43165 solution43165 = new Solution43165();
        System.out.println(solution43165.solution(numbers, target));
    }
}
