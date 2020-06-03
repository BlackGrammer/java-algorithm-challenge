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
        // 1  -- 5 / 5
        // 2  -- (5 + 5) / 5
        // 3  -- (5 + 5 + 5) / 5 == 5 - (5 + 5) / 5
        // 4  -- 5 - 5 / 5
        // 5  -- 5
        // 6  -- 5 + 5 / 5
        // 7  -- 5 + (5 + 5) / 5
        // 10 -- 5 + 5
        // 11 -- 55 / 5
        // 12 -- (55 + 5) / 5
        // 22 -- (55 + 55 ) /5
        // 111 -- (555

        Map<Integer, Integer> caseMap = new HashMap<>();
        caseMap.put(N, 1);
        for (int i = 1; i < N; i++) {
            int cnt;
            if (2 * i > N) {
                cnt = N-i+2;
            } else {
                cnt = i + 1;
            }
            caseMap.put(i, cnt);
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(5, 12) = " + s.solution(5, 12)); // 4 -- (55 + 5) / 5
        System.out.println("s.solution(2, 11) = " + s.solution(2, 11)); // 3 -- 22 / 2
    }

}
