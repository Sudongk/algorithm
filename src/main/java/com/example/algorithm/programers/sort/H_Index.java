package com.example.algorithm.programers.sort;

import java.util.Arrays;

public class H_Index {
    // citations : [3, 0, 6, 1, 5]
    // result : 3
    public int solution(int[] citations) {
        int answer = 0;

        // 배열을 정렬하게 되면 특정 인덱스 i부터 citations 배열 길이 만큼의 논문이 citations[i]번 이상 인용되었다고 할 수 있음
        Arrays.sort(citations);

        // i값을 증가시키고 논문의 수를 감소시키면서 비교 했을 때 인용 횟수가 남은 논문의 수 이상(즉, 같움)이 되었을 때의 논문의 수가 H-Index
        for(int i = 0; i < citations.length; i++) {
            // 인용된 논문의 수
            int h = citations.length - i;

            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        H_Index h_index = new H_Index();
        System.out.println(h_index.solution(citations));
    }
}