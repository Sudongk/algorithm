package com.example.algorithm.programmers.lv3;

import java.util.*;

public class Solution42627 {

    // jobs : [[0, 3], [1, 9], [2, 6]]
    // return : 9

    public int solution(int[][] jobs) {
        int answer = 0;

        int time = 0;
        int index = 0;

        // 작업의 소요시간을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 작업의 요청 시간을 기준으로 오름차순 정렬
        while (index < jobs.length || !pq.isEmpty()) {
            // 현재 시간 이하의 작업을 모두 큐에 삽입
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index++]);
            }
            // 큐가 비어있는 경우 현재 시간을 작업의 요청 시간으로 변경
            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else { // 큐가 비어있지 않은 경우
                int[] job = pq.poll();
                answer += time + job[1] - job[0];
                time += job[1];
            }
        }

        // 평균 시간 계산
        answer /= jobs.length;

        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        Solution42627 solution = new Solution42627();

        System.out.println(solution.solution(jobs));
    }

}
