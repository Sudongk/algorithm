package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution42747 {

    // citations : [3, 0, 6, 1, 5]
    // return : 3

    public int solution(int[] citations) {
        int answer = 0;

        // 오름차순 정렬
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            // h를 citations.length - i로 설정한 이유는 h번 이상 인용된 논문이 h편 이상이어야 하기 때문
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        Solution42747 solution = new Solution42747();

        int answer = solution.solution(citations);

        System.out.println(answer);
    }

}
