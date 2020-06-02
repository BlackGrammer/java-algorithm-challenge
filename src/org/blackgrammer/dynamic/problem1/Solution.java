package org.blackgrammer.dynamic.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * N으로 표현 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42895">프로그래머스</a>
 */
public class Solution {

    /*
     * N은 1 이상 9 이하입니다.
     * number는 1 이상 32,000 이하입니다.
     * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
     * 최솟값이 8보다 크면 -1을 return 합니다.
     */

    public int solution(int N, int number) {
        Map<String, Integer> caseStore = new HashMap<>();
        int answer = getCaseCnt(0, 0, 8, N, number, caseStore);
        return answer;
    }

    private int getCaseCnt(int prevCnt, int prevNum, int minNum, int n, int number, Map caseStore) {
        if (prevCnt > 8) return minNum;
        for (int i = 1, len = 8 - prevCnt; i <= len; i++) {
            StringBuilder unitStr = new StringBuilder();
            for (int i2 = 0; i2 < i; i2++) {
                unitStr.append(n);
            }
//            if(case)
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(5, 12) = " + s.solution(5, 12)); // 4 -- (55 + 5) / 5
        System.out.println("s.solution(2, 11) = " + s.solution(2, 11)); // 3 -- 22 / 2
    }

}
