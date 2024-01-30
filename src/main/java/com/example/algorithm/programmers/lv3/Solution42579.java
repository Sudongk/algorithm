package com.example.algorithm.programmers.lv3;

import java.util.*;

public class Solution42579 {

    // genres : ["classic", "pop", "classic", "classic", "pop"]
    // plays : [500, 600, 150, 800, 2500]
    // return : [4, 1, 3, 0]

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> rankMap = new HashMap<>();

        // 각 장르를 키, 재생수를 값으로 하는 HashMap 생성
        for (int i = 0; i < genres.length; i++) {
            rankMap.put(genres[i], rankMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 각 장르의 재생수 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> valList = new ArrayList<>(rankMap.entrySet());
        valList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<String> sortedGenres = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : valList) {
            sortedGenres.add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        int[] compareArr = {-1, -1};

        // 각 장르별로 재생수가 높은 노래 2개를 뽑아서 결과에 추가
        for (String sortedGenre : sortedGenres) {
            for (int i = 0; i < plays.length; i++) {
                if (genres[i].equals(sortedGenre)) {
                    // compareArr 초기화
                    if (init(plays, compareArr, i)) continue;

                    // 재생수가 같으면 인덱스가 더 작은 노래를 먼저 추가
                    if (plays[compareArr[0]] == plays[i]) {
                        compareArr[1] = i;
                        continue;
                    }

                    // 0번째 인덱스의 재생수보다 큰 재생수가 있으면 0번쨰 인덱스 값 변경 기존 0번째 인덱스를 1번째 인덱스로 변경
                    if (plays[compareArr[0]] < plays[i] && plays[compareArr[1]] < plays[i]) {
                        compareArr[1] = compareArr[0];
                        compareArr[0] = i;
                        continue;
                    }

                    // 1번째 인덱스의 재생수보다 큰 노래가 있으면 1번째 인덱스 값 변경
                    if (plays[compareArr[0]] > plays[i] && plays[compareArr[1]] < plays[i]) {
                        compareArr[1] = i;
                        continue;
                    }
                }
            }

            // 장르에 포함된 노래가 1개면 1개만 추가
            for (int i : compareArr) {
                if (i != -1) {
                    result.add(i);
                }
            }

            // compareArr 초기화
            compareArr = new int[]{-1, -1};
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static boolean init(int[] plays, int[] compareArr, int i) {
        if (compareArr[0] == -1) {
            compareArr[0] = i;
            return true;
        }

        if (compareArr[1] == -1) {
            if (plays[compareArr[0]] >= plays[i]) {
                compareArr[1] = i;
            } else {
                compareArr[1] = compareArr[0];
                compareArr[0] = i;
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution42579 solution = new Solution42579();
        String[] genres = {"A", "B", "A", "B", "A", "C"};
        int[] plays = {500, 600, 150, 800, 2500, 5000};

        System.out.println(Arrays.toString(solution.solution(genres, plays)));
    }

}
