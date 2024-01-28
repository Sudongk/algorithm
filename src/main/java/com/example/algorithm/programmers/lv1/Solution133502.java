package com.example.algorithm.programmers.lv1;

import java.util.Stack;

public class Solution133502 {
    // ingredients : [2, 1, 1, 2, 3, 1, 2, 3, 1]
    // result : 2
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            if (ingredient[i] == 1) {
                stack.add(ingredient[i]);
                for (int j = i + 1; j < ingredient.length; j++) {
                    if (ingredient[j] == 1) {
                        stack.clear();
                        break;
                    }

                    if (ingredient[j] == -1) {
                        continue;
                    }

                    if (ingredient[j] == 2) {
                        stack.add(ingredient[j]);
                    }

                }
            }


        }

        return answer;
    }



    public static void main(String[] args) {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        Solution133502 solution133502 = new Solution133502();
        System.out.println(solution133502.solution(ingredient));
    }
}
