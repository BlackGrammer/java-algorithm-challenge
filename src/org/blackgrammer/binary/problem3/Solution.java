package org.blackgrammer.binary.problem3;

import java.util.Arrays;

/**
 * 징검다리 _ 프로그래머스 _ 이분탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43236">프로그래머스</a>
 */
public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        answer = findAnswer(distance, rocks, n, new boolean[rocks.length], 0, answer, 0);
        return answer;
    }

    private int findAnswer(int distance, int[] rocks, int n, boolean[] eliminates, int eliminateCnt, int prevMinDistance, int start) {
        for (int i = start, len = rocks.length; i < len; i++) {
            boolean[] copyEliminates = Arrays.copyOf(eliminates, eliminates.length);
            int prevEliminateCnt = eliminateCnt;
            if (!copyEliminates[i]) {
                copyEliminates[i] = true;
                eliminateCnt++;

                if (eliminateCnt == n) {
                    int newMinDistance = findMinDistance(distance, rocks, copyEliminates);
                    prevMinDistance = Math.max(prevMinDistance, newMinDistance);
                } else {
                    prevMinDistance = Math.max(prevMinDistance, findAnswer(distance, rocks, n, copyEliminates, eliminateCnt, prevMinDistance, i+1));
                }
            }
            eliminateCnt = prevEliminateCnt;
        }
        return prevMinDistance;
    }

    private int findMinDistance(int distance, int[] rocks, boolean[] eliminates) {
        int min = distance;
        int prevPos = 0;
        for (int i = 0, len = rocks.length; i < len; i++) {
            if (eliminates[i]) continue;
            int pos = rocks[i];
            min = Math.min(min, pos - prevPos);
            prevPos = pos;
        }
        min = Math.min(min, distance - prevPos);
        return min;
    }

    public static void main(String[] args) {

//        25  |   [2, 14, 11, 21, 17] | 2 | 4
        Solution s = new Solution();
        System.out.println(s.solution(25, new int[]{2, 14, 11, 21, 17}, 2)); // 4
    }
}
