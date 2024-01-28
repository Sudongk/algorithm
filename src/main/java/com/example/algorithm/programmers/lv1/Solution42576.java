package com.example.algorithm.programmers.lv1;

import java.util.*;

public class Solution42576 {

    // participant : ["leo", "kiki", "eden"]
    // completion : ["eden", "kiki"]
    // result : "leo"
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();
        HashMap<String, Integer> completionMap = new HashMap<>();

        String result = null;

        for (String p : participant) {
            if (participantMap.containsKey(p)) {
                participantMap.put(p, participantMap.get(p) + 1);
            } else {
                participantMap.put(p, 1);
            }
        }

        for (String c : completion) {
            if (completionMap.containsKey(c)) {
                completionMap.put(c, completionMap.get(c) + 1);
            } else {
                completionMap.put(c, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = participantMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (completionMap.containsKey(entry.getKey())) {
                if (Objects.equals(entry.getValue(), completionMap.get(entry.getKey()))) {
                    continue;
                }
                result = entry.getKey();
                break;
            }

            result = entry.getKey();
            break;
        }


        return result;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution42576 solution42576 = new Solution42576();
        System.out.println(solution42576.solution(participant, completion));
    }

}
