package com.example.algorithm.programers.lv2;

import java.util.Arrays;

public class Solution181188 {
    // targets : [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
    // result : 3
    public int solution(int[][] targets) {
        int answer = 0;

        /**
        *  target들의 끝값을 기준으로 오름차순 정렬
         * 이유 : 전 target의 [1]-1값이 다음 target[0]보다 같거나 크다는 건 -> 무조건 겹침을 의미
         * 즉 다음 target의 시작값이 전 target의 끝값과 같거나 작다는건 전 target이 다음 target에 포함됨을 의미
         * ex) (1-3) (4-4 3-7 4-8) (5-11 11-13 10-14)
         * [[1, 4], [4, 5], [3, 7], [4, 8], [5, 12], [11, 13], [10, 14]]
         */
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));

        int end = Integer.MIN_VALUE;

        for(int[] target : targets){
            // end가 다음 target의 [0]값보다 작다 -> 겹치지 않다 -> 새로운 미사일 필요
            // else 겹친다 -> 관통 가능
            if(end < target[0]){
                // 개구간이기 때문에 정확한 범위를 위해 실제 끝나는 범위 조정을 위한 -1
                end = target[1] - 1;
                // 요격 미사일 추가
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] targets= {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};

        Solution181188 solution181188 = new Solution181188();
        System.out.println(solution181188.solution(targets));
    }
}
