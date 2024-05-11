package com.example.algorithm.programmers.lv2;

public class Solution87946 {

    // k : 80
    // dungeons : [[80,20],[50,40],[30,10]]
    // result : 3

    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        int dungeonCount = dungeons.length;
        int[] arr = new int[dungeonCount];

        for (int i = 0; i < dungeonCount; i++) {
            arr[i] = i;
        }

        permutation(arr, 0, dungeonCount, k, dungeons);

        return answer;
    }

    // 가능한 순번 인덱스 구하가 후 순서대로 던전 탐험
    private void permutation(int[] indexSeq, int depth, int dungeonCount, int k, int[][] dungeons) {
        if (depth == dungeonCount) {
            int count = explore(indexSeq, k, dungeons);

            // 던전 탐험 횟수 최대값 저장
            if (answer < count) {
                answer = count;
            }
            return;
        }

        // 던전 탐험 횟수가 이미 최대값이면 종료
        if (answer == dungeonCount) {
            return;
        }

        for (int i = depth; i < dungeonCount; i++) {
            swap(indexSeq, i, depth);
            permutation(indexSeq, depth + 1, dungeonCount, k, dungeons);
            swap(indexSeq, i, depth);
        }
    }

    // 순번 인덱스 교환
    private void swap(int[] indexSeq, int i, int j) {
        int temp = indexSeq[i];
        indexSeq[i] = indexSeq[j];
        indexSeq[j] = temp;
    }

    // 던전 탐험
    private int explore(int[] indexSeq, int k, int[][] dungeons) {
        int count = 0;
        for (int idx : indexSeq) {
            // 유저의 피로도가 던전의 최소 필요 피로도보다 크거나 같으면 던전 탐험
            if (dungeons[idx][0] <= k) {
                // 유저의 피로도 감소
                k -= dungeons[idx][1];
                // 던전 탐험 횟수 증가
                count++;
            } else {
              // 피로도가 만족되지 않으면 루프 종료 던전 탐험 불가능하면 종료
              break;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        Solution87946 solution = new Solution87946();

        int answer = solution.solution(k, dungeons);

        System.out.println(answer);
    }

}
