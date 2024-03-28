package com.example.algorithm.programmers.lv3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution42628 {

    // operations : ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
    // return : [0, 0]

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        // 최소 힙 최소 : 값이 우선순위인 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 최대 힙 : 최대 값이 우선순위인 큐
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] split = op.split(" ");
            if (split[0].equals("I")) {
                pq.offer(Integer.parseInt(split[1]));
                reversePq.offer(Integer.parseInt(split[1]));
            }

            if (split[0].equals("D")) {
                if (pq.isEmpty() || reversePq.isEmpty()) {
                    continue;
                }

                if (split[1].equals("1")) {
                    int max = reversePq.poll();
                    pq.remove(max);
                } else {
                    int min = pq.poll();
                    reversePq.remove(min);
                }
            }
        }

        if (pq.isEmpty() || reversePq.isEmpty()) {
            return answer;
        }

        answer[0] = reversePq.poll();
        answer[1] = pq.poll();

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        Solution42628 solution = new Solution42628();

        int[] answer = solution.solution(operations);

        System.out.println(Arrays.toString(answer));
    }

}
