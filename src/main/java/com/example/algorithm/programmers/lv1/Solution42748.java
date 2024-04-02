package com.example.algorithm.programmers.lv1;

import java.util.*;

public class Solution42748 {

    // array : [1, 5, 2, 6, 3, 7, 4]
    // commands : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    // return : [5, 6, 3]

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1] - 1;
            int targetIndex = commands[i][2] - 1;

            // 최소힙을 이용한 정렬 (부모노드는 항상 자식노드보다 작다)
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

            for (int j = startIndex; j <= endIndex; j++) {
                pq.offer(array[j]);
            }

            for (int k = 0; k <= targetIndex; k++) {
                // 값을 poll 할 때마다 최소값이 나오고 내부에서 정렬이 일어난다.
                Integer targetVal = pq.poll();
                if (k == targetIndex) {
                    answer[i] = targetVal;
                }
            }

            pq.clear();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution42748 solution = new Solution42748();

        int[] answer = solution.solution(array, commands);

        System.out.println(Arrays.toString(answer));
    }

}
