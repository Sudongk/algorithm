package com.example.algorithm.programmers.lv3;

import java.util.*;

public class Solution42627 {

    // jobs : [[0, 3], [1, 9], [2, 6]]
    // return : 9

    public int solution(int[][] jobs) {
        // 각 작업의 요청 시점부터 처리완료 시점까지의 합을 작업의 갯수로 나눈 값
        int answer = 0;

        // 작업이 요청되는 시점 기준으로 오름차순 정렬 * 핵심
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 작업의 소요시간 기준으로 오름차순 정렬 * 핵심
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 작업 배열 인덱스
        int jobs_index = 0;
        // 처리 완료된 작업 개수
        int finish_job = 0;
        // 작업 처리 완료 시간 디스크는 한번에 하나의 작업만 수행 가능하기 때문에 작업 완료 시점은 작 작업의 소요 시간의 합계
        int end_time = 0;

        while(true) {
            // 모든 작업을 처리했다면 종료
            if(finish_job == jobs.length) break;

            // 작업 처리 중 요청된 작업 add
            while(jobs_index < jobs.length && jobs[jobs_index][0] <= end_time) {
                pq.add(jobs[jobs_index++]);
            }

            // 이전 작업 처리 중 요청된 작업이 있는 경우
            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                // 대기시간 + 작업 소요시간
                // 작업 요청부터 종료까지 걸린 시간 추가
                answer += end_time - job[0] + job[1];
                // 작업 처리 완료 시간 갱신
                end_time += job[1];
                // 처리 완료된 작업 개수 1 증가
                finish_job++;
            }
            // 이전 작업 처리 중 요청된 작업이 없는 경우
            else {
                end_time = jobs[jobs_index][0]; // 다음 작업 요청 시점으로 갱신
            }
        }

        return answer / jobs.length;

    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};

        Solution42627 solution = new Solution42627();

        System.out.println(solution.solution(jobs));
    }

}
