package com.example.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution154540 {
    // maps : ["X591X","X1X5X","X231X", "1XXX1"]
    // result : [1, 1, 27]
    // maps : ["XXX","XXX","XXX"]
    // result : [-1]
    public static int[] solution(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<maps.length ; i++) {
            int sum = 0;
            for(int j=0 ; j<maps[i].length() ; j++) {
                sum = getTerritory(i, j, visit, maps);
                if(sum>0) {
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);

        return list.isEmpty() ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int getTerritory(int i, int j, boolean[][] visit, String[] maps) {
        if(i<0 || j<0 || i>=visit.length || j>=visit[0].length || visit[i][j] || maps[i].charAt(j)=='X') {
            return 0;
        }

        visit[i][j] = true;

        return (maps[i].charAt(j)-'0')
                + getTerritory(i-1,j,visit,maps)
                + getTerritory(i+1,j,visit,maps)
                + getTerritory(i,j-1,visit,maps)
                + getTerritory(i,j+1,visit,maps);
    }

    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));
    }
}
