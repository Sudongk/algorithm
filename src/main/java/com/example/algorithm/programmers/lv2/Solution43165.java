package com.example.algorithm.programers.lv2;

public class Solution43165 {
    // numbers : [1, 1, 1, 1, 1]
    // target : 3
    // result : 5
    private static int cnt = 0;

    public int solution(int[] numbers, int target) {
        // DFS를 이용해 풀이
        dfs(0, target, numbers);

        return cnt;
    }

    public void dfs(int index, int target, int[] numbers) {
        // 주어진 배열의 마지막 자리일 경우
        if (index == numbers.length) {
            // sum 초기화
            int sum = 0;

            for (int i = 0; i < numbers.length; i++) {
                // sum에 주어진 배열의 수를 더한다
                sum += numbers[i];
            }
            // 배열을 모두 더한 값이 target과 같은 경우
            if (sum == target) {
                cnt++;
            }
        }
        // 마지막 자리가 아닐 경우 재귀함수를 통해 부호를 바꿔가며 탐색
        else {
            numbers[index] *= 1;
            dfs(index + 1, target, numbers);

            numbers[index] *= -1;
            dfs(index + 1, target, numbers);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Solution43165 solution43165 = new Solution43165();
        System.out.println(solution43165.solution(numbers, target));
    }
}
