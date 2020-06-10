package org.blackgrammer.dynamic.problem6;


import java.util.Arrays;

/**
 * 도둑질 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42897">프로그래머스</a>
 */
public class Solution {
    public int solution(int[] money) {
        int len = money.length;
        boolean[] robbed = new boolean[len];
        int i = 0;
        while (true) {
            int i1 = (i - 1 + len) % len;
            int i2 = i % len;
            int i3 = (i + 1 + len) % len;
            int iPrev = (i - 2 + len) % len;
            int iNext = (i + 2 + len) % len;

            int m1 = money[i1];
            int m2 = money[i2];
            int m3 = money[i3];

            int[] ordered = new int[]{m1, m2, m3};
            Arrays.sort(ordered);
            int max = ordered[2];
            int mid = ordered[1];

            if (max < m1 + m3 && (!robbed[iPrev] && !robbed[iNext])) {
                robbed[i1] = true;
                robbed[i3] = true;
                robbed[i2] = false;
            } else {
                if (max == m1 && !robbed[iPrev]) {
                    robbed[i1] = true;
                    robbed[i2] = false;
                } else if (max == m2) {
                    robbed[i2] = true;
                    robbed[i1] = false;
                    robbed[i3] = false;
                } else if (max == m3 && !robbed[iNext]) {
                    robbed[i3] = true;
                    robbed[i1] = false;
                } else {
                    if (mid == m1 && !robbed[iPrev]) {
                        robbed[i1] = true;
                        robbed[i2] = false;
                    } else if (mid == m2) {
                        robbed[i2] = true;
                        robbed[i1] = false;
                        robbed[i3] = false;
                    } else if (mid == m3 && !robbed[iNext]) {
                        robbed[i3] = true;
                        robbed[i1] = false;
                    }
                }
            }

            if (++i == 2 * len) break;
        }

        int answer = 0;
        int robIdx = 0;
        for (boolean isRobbed : robbed) {
            if (isRobbed) answer += money[robIdx];
            robIdx++;
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 2, 5, 1, 5, 8}));
        // 3,5,5 -- 13
        System.out.println(s.solution(new int[]{1, 2, 1, 2, 3, 2}));
        // 2, 2, 2 -- 6
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5, 5, 3, 2, 1}));
        // 2, 4, 5, 2 -- 13 // 1, 3 => 2, 4 =>
    }
}
