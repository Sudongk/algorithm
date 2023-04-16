package com.example.algorithm.programers;

public class Solution160586 {
    // keymap : ["ABACD", "BCEFD"]
    // targets :["ABCD","AABB"]
    // result : [9, 4]
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            String[] target = targets[i].split("");
            for (int j = 0; j < target.length; j++) {
                int idx = checkExist(keymap, target[j]);
                if (idx != 1000000) {
                    sum += idx + 1;
                } else {
                    sum = idx;
                }
            }

            if (sum == 1000000) {
                sum = -1;
            }

            answer[i] = sum;
        }


        return answer;
    }

    public static int checkExist(String[] keymap, String target) {
        int index = 1000000;
        for (int i = 0; i < keymap.length; i++) {
            if (keymap[i].contains(target)) {
                int newIndex = keymap[i].indexOf(target);
                if (newIndex < index) {
                    index = newIndex;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        String[] keymap = {"AA", "AWWER", "AAWC"};
        String[] targets = {"B", "WW", "B"};
        Solution160586 solution = new Solution160586();
        int[] result = solution.solution(keymap, targets);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
