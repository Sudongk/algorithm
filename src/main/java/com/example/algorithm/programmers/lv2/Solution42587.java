package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42587 {

    // priorities : [2, 1, 3, 2]
    // location : 2
    // return : 1

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();

            // 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 확인
            boolean higherPriorityExist = queue.stream().anyMatch(p -> p.priority > currentProcess.priority);

            if (higherPriorityExist) {
                // 더 높은 우선순위의 프로세스가 있으면 다시 큐에 추가
                queue.add(currentProcess);
            } else {
                // 높은 우선순위의 프로세스가 없으면 실행하고 정답 증가
                answer++;
                // 만약 실행한 프로세스가 찾고자 하는 프로세스라면 종료
                if (currentProcess.location == location) {
                    break;
                }
            }
        }

        return answer;
    }

    class Process {
        int location;
        int priority;

        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        Solution42587 solution = new Solution42587();

        System.out.println(solution.solution(priorities1, location1));

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        System.out.println(solution.solution(priorities2, location2));
    }

}

