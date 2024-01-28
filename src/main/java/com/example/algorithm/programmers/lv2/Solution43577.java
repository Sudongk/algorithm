package com.example.algorithm.programmers.lv2;

import java.util.*;

public class Solution43577 {
    // phone_book : ["119", "97674223", "1195524421"]
    // result : false

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 전화번호 배열을 정렬을 통해 접두어 관계가 인접하게 정렬
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                // 정렬된 상태에서 다음 번호가 현재 번호의 접두어인 경우
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};

        Solution43577 solution43577 = new Solution43577();
        System.out.println(solution43577.solution(phone_book));
    }
}
