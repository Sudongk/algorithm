package com.example.algorithm.programmers.kakaoBlindRecruitment;


//  문제의 핵심: 소수판별에서의 효율적인 알고리즘 구현(시간복잡도)
public class k진수에서_소수_개수_구하기 {
    // n : 437674
    // k : 3
    // result : 3
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder kNum = new StringBuilder();

        while (n >= k) {
            int rest = n % k;
            n = n / k;

            kNum.insert(0, rest);
        }

        kNum.insert(0, n);

        int idx = 0;

        while (idx < kNum.length()) {
            char curVal = kNum.charAt(idx);

            if (curVal == '0') {
                idx++;
                continue;
            }

            int curIdx = idx;
            StringBuilder num = new StringBuilder();

            for (int i = curIdx; i < kNum.length(); i++) {
                char val = kNum.charAt(curIdx);

                if (val == '0') {
                    curIdx++;
                    break;
                }

                curIdx++;
                num.append(val);
            }

            if (isPrime(Long.parseLong(num.toString()))) {
                answer += 1;
            }

            idx = curIdx;
        }

        return answer;
    }

    public static boolean isPrime(long num) {
        // 0 또는 1은 소수가 아님
        if(num < 2) return false;

        // 2는 소수
        if(num == 2) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 1000000;
        int k = 3;

        k진수에서_소수_개수_구하기 solution = new k진수에서_소수_개수_구하기();
        int result = solution.solution(n, k);
        System.out.println(result);
    }
}
