package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42586 {

    // progresses : [93, 30, 55]
    // speeds : [1, 30, 5]
    // return : [2, 1]

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        // 남은 일의 갯수
        int left = progresses.length;

        // 완료 지점
        int idx = 0;

        while (left > 0) {
            int count = 0;

            for (int i = 0; i < progresses.length; i++) {
                progresses[i] = progresses[i] + speeds[i];
            }

            for (int i = idx; i < progresses.length; i++) {
                // 배포한 작업 카운트
                if (progresses[i] >= 100) {
                    count++;
                    idx++;
                }else break;
            }

            if (count != 0) {
                answer.add(count);
                left = left - count;
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        Solution42586 solution = new Solution42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(answer));
    }

}
