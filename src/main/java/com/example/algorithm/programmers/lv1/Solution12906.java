package com.example.algorithm.programmers.lv1;

import java.util.*;
public class Solution12906 {

    // arr : [1,1,3,3,0,1,1]
    // answer : [1,3,0,1]

    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            if (answer.isEmpty()) {
                answer.add(i);
                continue;
            }

            if (answer.get(answer.size() - 1) != i) {
                answer.add(i);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        Solution12906 solution = new Solution12906();
        int[] arr = {1,1,3,3,0,1,1};
        int[] answer = solution.solution(arr);
        System.out.println(Arrays.toString(answer));
    }

}
