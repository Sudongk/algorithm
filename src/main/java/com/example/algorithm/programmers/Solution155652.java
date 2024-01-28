package com.example.algorithm.programers;

import java.util.ArrayList;
import java.util.List;

public class Solution155652 {
    // s : "aukks"
    // skip : "wbqd"
    // index : 5
    // result : "happy"
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                // temp = z 일때 a로 초기화
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "avkks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(solution(s, skip, index));
    }

}
