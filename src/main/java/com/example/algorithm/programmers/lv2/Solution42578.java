package com.example.algorithm.programers.lv2;

import java.util.*;

public class Solution42578 {
    // clothes : [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
    // return : 5

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        // 의상의 종류별로 개수를 세어 HashMap에 저장
        for (String[] clothe : clothes) {
            String type = clothe[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 각 의상의 종류별 의상의 경우의 수를 (의상의 개수 + 1) 곱하여 모든 경우의 수 계산
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        // 모든 종류의 의상에서 아무것도 입지 않은 경우는 제외
        return answer - 1;
    }

    public static void main(String[] args) {
        Solution42578 solution = new Solution42578();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution.solution(clothes));
    }

}
