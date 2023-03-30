package com.example.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution159994 {
    // cards1 : ["i", "drink", "water"]
    // cards2 : ["want", "to"]
    // goal : ["i", "want", "to", "drink", "water"]
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int i = 0, j = 0;

        for (String e : goal) {
            System.out.println(e);
            if (i < cards1.length && cards1[i].equals(e)) {
                System.out.println("if");
                i++;
            } else if (j < cards2.length && cards2[j].equals(e)) {
                System.out.println("else if");
                j++;
            } else {
                System.out.println("else");
                answer = "No";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }
}
