package com.example.algorithm.programers.sort;

import java.util.Arrays;

public class H_Index {
    // citations : [3, 0, 6, 1, 5]
    // result : 3
    public int solution(int[] citations) {
        int answer = 0;

        // 0, 1, 3, 5, 6
        Arrays.sort(citations);

        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        H_Index h_index = new H_Index();
        System.out.println(h_index.solution(citations));
    }
}