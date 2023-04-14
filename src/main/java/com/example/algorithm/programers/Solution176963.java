package com.example.algorithm.programers;

import java.util.HashMap;
import java.util.Map;

public class Solution176963 {
    // name : ["may", "kein", "kain", "radi"]
    // yearning : [5, 10, 1, 3]
    // photo : [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
    // result : [19, 15, 6]
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> nameYearnMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            nameYearnMap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String curVal = photo[i][j];
                if (nameYearnMap.containsKey(curVal)) {
                    sum += nameYearnMap.get(curVal);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution176963 solution = new Solution176963();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        int[] answer = solution.solution(name, yearning, photo);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}

