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
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int middle = distance / 2;

        while (true) {
            int prevPos = 0;
            int numberOfEliminate = 0;
            int minDistance = distance;

            for (int rock : rocks) {
                boolean isLast = rock == rocks[rocks.length - 1];
                int targetDistance = rock - prevPos;
                if (targetDistance < middle) {
                    numberOfEliminate++;
                } else {
                    if (isLast && distance - rock < middle) {
                        numberOfEliminate++;
                        minDistance = Math.min(minDistance, distance - prevPos);
                    } else {
                        minDistance = Math.min(minDistance, targetDistance);
                        prevPos = rock;
                    }
                }
            }

            if (numberOfEliminate == n || Math.abs(left - right) <= 1) return minDistance;

            if (numberOfEliminate > n) right = middle;
            else left = middle;
            middle = (left + right) / 2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(25, new int[]{2, 14, 11, 21, 17}, 2)); // 4
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 1)); // 3
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 2)); // 4
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 3)); // 6
        System.out.println(s.solution(12, new int[]{2, 4, 6, 8, 10}, 3)); // 4
        System.out.println(s.solution(12, new int[]{2, 4, 6, 8, 10}, 4)); // 6
        System.out.println(s.solution(12, new int[]{2, 4, 6, 8, 10}, 1)); // 2
        System.out.println(s.solution(11, new int[]{2, 4, 6, 8, 10}, 1)); // 2
        System.out.println(s.solution(11, new int[]{2, 4, 6, 8, 10}, 5)); // 11
    }
}
