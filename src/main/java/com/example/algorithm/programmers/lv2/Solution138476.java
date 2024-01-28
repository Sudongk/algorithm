package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution138476 {
    // k : 6
    // tangerine : [1, 3, 2, 5, 4, 5, 2, 3]
    // result : 3
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int e : tangerine) {
            if (!map.containsKey(e)) {
                map.put(e, 1);
                continue;
            }

            map.put(e, map.get(e) + 1);
        }

        // Map의 value 값만 추출하여 리스트로 저장
        List<Integer> values = new ArrayList<>(map.values());

        // value 값으로 내림차순 정렬
        values.sort(Collections.reverseOrder());

        // 크기 다른 귤 카운트
        int count = 0;

        for (Integer value : values) {
            // 처음부터 해당 귤의 수가 목표 갯수라면 바로 1증가 후 리턴
            if (count == 0 && value == k) {
                answer++;
                break;
            }
            // count가 목표 갯수보단 작으면 count, answer 증가
            if (count < k) {
                count += value;
                answer++;
            }
            // count가 목표 갯수와 같거나 크면 빠져나온다
            if (count == k || count > k) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        Solution138476 solution138476 = new Solution138476();
        System.out.println(solution138476.solution(k, tangerine));
    }
}
