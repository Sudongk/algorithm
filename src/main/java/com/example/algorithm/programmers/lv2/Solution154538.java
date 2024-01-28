package com.example.algorithm.programmers.lv2;

import java.util.HashSet;

public class Solution154538 {
    // x : 10
    // y : 40
    // n : 30
    // result : 1
    public int solution(int x, int y, int n) {

        // 연산 횟수를 기록할 변수 cnt를 초기화
        int cnt = 0;

        // 현재 집합을 나타내는 curr, 다음 집합을 나타내는 next
        HashSet<Integer> curr = new HashSet<>(), next = null;

        // 시작 숫자 x를 현재 집합 curr에 추가
        curr.add(x);

        // curr 집합이 비어 있지 않은 동안 반복
        while (!curr.isEmpty()) {
            // 만약 curr 집합에 목표 숫자 y가 포함되어 있다면, 최소 연산 횟수인 cnt를 반환
            if (curr.contains(y))
                return cnt;

            // 다음 단계에서 사용할 집합 next를 초기화
            next = new HashSet<>();

            // curr 집합에 있는 각 숫자에 대해 가능한 연산을 시도
            for (int val : curr) {
                // 현재 숫자에 n을 더한 값을 계산
                int pVal = val + n;
                // 현재 숫자를 2로 곱한 값을 계산
                int dVal = val * 2;
                // 현재 숫자를 3으로 곱한 값을 계산
                int tVal = val * 3;

                // 계산된 값들 중 y보다 작거나 같은 것들만 다음 집합 next에 추가
                if (pVal <= y) next.add(pVal);
                if (dVal <= y) next.add(dVal);
                if (tVal <= y) next.add(tVal);
            }

            // 다음 단계를 위해 curr를 next로 업데이트하고, 연산 횟수 cnt를 1 증가시
            curr = next;
            cnt++;
        }

        // curr 집합이 비어 있으면서 y에 도달하지 못한 경우 -1을 반환
        return -1;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 30;

        Solution154538 solution154538 = new Solution154538();
        System.out.println(solution154538.solution(x, y, n));
    }
}
