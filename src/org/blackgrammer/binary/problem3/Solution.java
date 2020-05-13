package org.blackgrammer.binary.problem3;

import java.sql.Array;
import java.util.*;

/**
 * 징검다리 _ 프로그래머스 _ 이분탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43236">프로그래머스</a>
 */
public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0, left = 1, right = distance;

        while (left <= right) {
            int middle = (left + right) / 2;
            int prevRock = 0;
            int eliminatedCnt = 0;

            for (int rock : rocks) {
                if (rock - prevRock < middle) {
                    eliminatedCnt++;
                } else {
                    prevRock = rock;
                }
            }
            if (distance - prevRock < middle) eliminatedCnt++;

            if (eliminatedCnt <= n) {
                answer = Math.max(middle, answer);
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return answer;
    }
}
