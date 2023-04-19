package com.example.algorithm.programers.greedy;

import java.util.Arrays;

public class GymClothes {
    // n : 5
    // lost : [2, 4]
    // reserve : [1, 3, 5]
    // result : 5
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        // 정렬이 안되어있울수 있어서 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int reserved = 0;

        // 여벌이 있는 학생이 도난 당했을 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }

            int left = lost[i] - 1;
            int right = lost[i] + 1;

            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) {
                    continue;
                }

                if (reserve[j] == left) {
                    reserve[j] = -1;
                    reserved += 1;

                    break;
                }

                if (reserve[j] == right) {
                    reserve[j] = -1;
                    reserved += 1;

                    break;
                }
            }
        }

        return answer + reserved;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] lost = {2, 3};
        int[] reserve = {3, 4};

        GymClothes gymClothes = new GymClothes();
        int solution = gymClothes.solution(n, lost, reserve);
        System.out.println(solution);
    }
}
