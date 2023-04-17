package com.example.algorithm.programers;

import java.util.HashMap;
import java.util.Map;

public class Solution160586 {
    // keymap : ["ABACD", "BCEFD"]
    // targets :["ABCD","AABB"]
    // result : [9, 4]
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // keymap의 각 요소의 인덱스를 Map형태로 저장
        HashMap<Character,Integer> map = new HashMap<>();

        for (String key : keymap) {
            for (int j = 0; j < key.length(); j++) {

                char curIdx = key.charAt(j);

                if (map.containsKey(curIdx)){
                    // 현재 인덱스가 기존의 인덱스보다 작으면 교체
                    if(map.get(curIdx) > j){
                        map.replace(curIdx, j);
                    }
                }else{
                    map.put(curIdx, j);
                }
            }
        }

        for(int i = 0; i < targets.length; i++){
            int sum = 0;

            for(int j=0; j<targets[i].length();j++){

                char target = targets[i].charAt(j);

                if(map.containsKey(target)){
                    // 인덱스이기 때문에 실체 누른 횟수 출력을 위한 +1
                    sum += map.get(target) + 1;
                }else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"NAA", "PPAWWER", "QAAWC"};
        String[] targets = {"AAAAA", "WW", "B"};
        Solution160586 solution = new Solution160586();
        int[] result = solution.solution(keymap, targets);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
