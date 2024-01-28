package com.example.algorithm.programers.lv1;


import java.util.*;

public class Solution150370 {
    // today : "2022.05.19"
    // terms : ["A 6", "B 12", "C 3"]
    // privacies : ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
    // result : [1, 3]
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int todayNum = Integer.parseInt(today.replace(".",  ""));

        // 약관 종류를 키, 기간을 값
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String tKey = split[1];
            Integer t = termMap.get(tKey);

            String date = split[0];

            String[] dateSplit = date.split("\\.");

            String y = dateSplit[0];
            String m = dateSplit[1];
            String d = dateSplit[2];

            int targetDate = Integer.parseInt(calDate(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d), t));
            if (targetDate < todayNum) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    private static String calDate(int y, int m, int d, int t) {
        int ny = y;
        int nm = m + t;
        int nd = d;

        // 달이 12보다 크면 해가 넘어가므로 년도 증가 시키기
        if (nm > 12) {
            while (nm > 12) {
                ny++;
                nm = nm - 12;
            }
        }

        // 일이 1보다 작으면 일을 28일로 초기화시킨후 달도 1 감소
        if (nd == 0) {
            nd = 28;
            nm--;
        }

        String strY = String.valueOf(ny);
        String strM = String.valueOf(nm);
        String strD = String.valueOf(nd);

        // 달과 일이 한자리면 앞에 0 붙이기
        if (strM.length() == 1) {
            strM = "0" + strM;
        }

        if (strD.length() == 1) {
            strD = "0" + strD;
        }

        return strY + strM + strD;
    }


    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"A 100"};
        String[] privacies = {"2020.01.28 A"};

        Solution150370 solution150370 = new Solution150370();
        System.out.println(solution150370.solution(today, terms, privacies));
    }
}