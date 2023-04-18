package com.example.algorithm.programers;

import java.util.ArrayList;
import java.util.List;

public class Solution161990 {
    // wallpaper : [".#...", "..#..", "...#."]
    // result : [0, 1, 3, 4]
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        x.sort(Integer::compareTo);
        y.sort(Integer::compareTo);

        int lux = x.get(0), luy = y.get(0);
        int rdx = x.get(x.size() - 1) + 1, rdy = y.get(y.size() - 1) + 1;

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx;
        answer[3] = rdy;

        return answer;
    }

    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};

        Solution161990 solution161990 = new Solution161990();

        int[] solution = solution161990.solution(wallpaper);

        for (int i : solution) {
            System.out.println(i);
        }
    }
}
