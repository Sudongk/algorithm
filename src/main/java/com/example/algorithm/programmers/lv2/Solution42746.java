package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42746 {

    // numbers : [6, 10, 2]
    // return : "6210"

    public String solution(int[] numbers) {
        String answer = "";

        // 우선순위 큐 - 최대 힙(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        // 조합 가능한 숫자 구하고 우선순위 큐에 삽입
        permutation(numbers, new int[numbers.length], new boolean[numbers.length], 0, numbers.length, pq);

        answer = String.valueOf(pq.poll());

        return answer;
    }

    // 순열을 구하는 재귀 함수
    public void permutation(int[] numbers, int[] out, boolean[] visited, int depth, int r, PriorityQueue<Integer> pq) {
        StringBuilder sb = new StringBuilder();
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                if (out[i] == 0) {
                    break;
                }
                sb.append(out[i]);
            }
            pq.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = numbers[i];
                permutation(numbers, out, visited, depth + 1, r, pq);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        Solution42746 solution = new Solution42746();

        String answer = solution.solution(numbers);

        System.out.println(answer);
    }

}
