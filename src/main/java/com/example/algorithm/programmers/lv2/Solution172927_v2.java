package com.example.algorithm.programmers.lv2;

import java.util.HashMap;

public class Solution172927_v2 {
    // picks: [1,3,2]
    // minerals: ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]
    // result: 12

    HashMap<String, Integer> map ;
    int[][] cost;
    String[] minerals;
    int minLen;
    public int solution(int[] picks, String[] minerals) {
        map = new HashMap<>();
        int index = 0;
        this.minerals = minerals;
        minLen = Integer.MAX_VALUE;
        map.put("diamond", index++);
        map.put("iron", index++);
        map.put("stone", index++);
        cost = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int pickLen = 0;
        for (int x : picks) pickLen += x;

        dfs(new int[pickLen], 0, picks);

        return minLen;
    }

    public void dfs(int arr[], int L, int[] picks) {
        if (L == arr.length) {
            minLen = Math.min(minLen, getLen(arr));
            return;
        }

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                arr[L] = i;
                dfs(arr, L + 1, picks);
                picks[i]++;
            }
        }
    }
    //곡괭이 종류info[], 곡괭이 개수 pick, map
    public int getLen(int[] arr){
        int ret = 0;
        int mIndex = 0;

        for (int x : arr) {
            int cnt = 5;
            while (cnt-- > 0) {
                if (mIndex == minerals.length) return ret;
                ret += cost[x][map.get(minerals[mIndex++])];
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] picks = {1,3,2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        Solution172927_v1 solution172927V1 = new Solution172927_v1();

        System.out.println(solution172927V1.solution(picks, minerals));
    }
}
