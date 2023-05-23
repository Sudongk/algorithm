package com.example.algorithm.programers.lv0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution120956 {
    // babbling : ["aya", "yee", "u", "maa", "wyeoo"]
    // result : 1
    static List<String> permutations = new ArrayList<>();

    public int solution(String[] babbling) {
        int answer = 0;
        String[] pronunciations = {"aya", "ye", "woo", "ma"};

        int length = pronunciations.length;
        String[] output = new String[length];
        boolean[] isVisit = new boolean[length];

        // 가능힌 모든 조합
        for(int cnt = 1; cnt <= length; cnt++) {
            permutation(pronunciations, output, isVisit, 0, length, cnt);
        }

        System.out.println(Arrays.toString(permutations.toArray()));

        for (int i = 0; i < babbling.length; i++) {
            if (permutations.contains(babbling[i])) {
                answer++;
            }
        }

        return answer;
    }

    public static void permutation(String[] array, String[] output, boolean[] isVisit, int depth, int length, int count) {
        if(count == 0) {
            String str = Arrays.stream(output).filter(i -> i != null).collect(Collectors.joining());
            permutations.add(str);

            return;
        }

        for(int i = 0; i < length; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                output[depth] = array[i];

                permutation(array, output, isVisit, depth+1, length, count-1);

                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        Solution120956 solution120956 = new Solution120956();
        System.out.println(solution120956.solution(babbling));
    }
}

/**
 *
 * 간단한 풀이
 class Solution {
     public int solution(String[] babbling) {
         int answer = 0;

         for(int i =0; i < babbling.length; i++) {
             babbling[i] = babbling[i].replace("aya", "1");
             babbling[i] = babbling[i].replace("woo", "1");
             babbling[i] = babbling[i].replace("ye", "1");
             babbling[i] = babbling[i].replace("ma", "1");
             babbling[i] = babbling[i].replace("1", "");

             if(babbling[i].isEmpty()) {
                answer = answer + 1;
             }
         }

         return answer;
     }
 }
 * */
