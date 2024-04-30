package com.example.algorithm.programmers.lv1;

import java.util.*;

public class Solution42840 {

    // answers : [1, 2, 3, 4, 5]
    // return : [1]

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] student1RandomSeq = {1, 2, 3, 4, 5};
        int[] student2RandomSeq = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3RandomSeq = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 학생별 정답 수
        int[] studentsAnswerCount = new int[3];

        // 정답 배열 인덱스
        int answersIndex = 0;

        // 학생별 찍는 번호 배열 인덱스
        int student1Index = 0;
        int student2Index = 0;
        int student3Index = 0;

        // 정답 수 계산
        while (answersIndex != answers.length) {

            // 학생별 정답 수 계산
            if (student1RandomSeq[student1Index] == answers[answersIndex]) {
                studentsAnswerCount[0]++;
            }

            if (student2RandomSeq[student2Index] == answers[answersIndex]) {
                studentsAnswerCount[1]++;
            }

            if (student3RandomSeq[student3Index] == answers[answersIndex]) {
                studentsAnswerCount[2]++;
            }

            // 배열 인덱스 증가
            if (student1Index == student1RandomSeq.length - 1) {
                student1Index = 0;
            }else {
                student1Index++;
            }

            if (student2Index == student2RandomSeq.length - 1) {
                student2Index = 0;
            }else {
                student2Index++;
            }

            if (student3Index == student3RandomSeq.length - 1) {
                student3Index = 0;
            }else {
                student3Index++;
            }

            answersIndex++;
        }

        // 최대 정답 수 찾기
        for (int i = 0; i < studentsAnswerCount.length; i++) {
            int maxVal = Arrays.stream(studentsAnswerCount).max().getAsInt();

            if (studentsAnswerCount[i] == maxVal) {
                answer.add(i + 1);
            }
        }

        // List<Integer> -> int[]
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        Solution42840 solution = new Solution42840();

        int[] answer = solution.solution(answers);

        System.out.println(Arrays.toString(answer));
    }

}
