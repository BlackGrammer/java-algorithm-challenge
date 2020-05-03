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

        int[] diffArr = new int[rocks.length + 3];
        diffArr[0] = 0;
        diffArr[rocks.length + 2] = 0;
        int idx = 1;
        int prevPos = 0;
        for (int rock : rocks) {
            diffArr[idx] = rock - prevPos;
            prevPos = rock;
            idx++;
        }
        diffArr[rocks.length + 1] = distance - prevPos;

        while (n > 0) {
            int minPos = 1;
            int minNeighborPos = 2;
            int minSum = diffArr[1] + diffArr[2];
            for (int i = 2, len = diffArr.length - 1; i < len; i++) {
                int target = diffArr[i];
                int nextVal = diffArr[i + 1];
                int prevVal = diffArr[i - 1];
                if (diffArr[minPos] > target) {
                    minPos = i;
                    if (prevVal == 0) minNeighborPos = i + 1;
                    else if (nextVal == 0) minNeighborPos = i - 1;
                    else minNeighborPos = prevVal < nextVal ? i - 1 : i + 1;
                    minSum = target + diffArr[minNeighborPos];
                } else if (diffArr[minPos] == target) {
                    if (minSum > target + nextVal) {
                        minPos = i;
                        minNeighborPos = i + 1;
                        minSum = target + nextVal;
                    }
                    if (minSum > target + prevVal) {
                        minPos = i;
                        minNeighborPos = i - 1;
                        minSum = target + nextVal;
                    }
                }

            }

            int[] newDiffArr = new int[diffArr.length - 1];
            int newIndex = 0;
            for (int i = 0, len = diffArr.length; i < len; i++) {
                if (i == minPos) {
                    if (minPos > minNeighborPos) {
                        newDiffArr[newIndex - 1] = minSum;
                        continue;
                    } else {
                        newDiffArr[newIndex] = minSum;
                        i++;
                    }
                } else {
                    newDiffArr[newIndex] = diffArr[i];
                }
                newIndex++;
            }
            diffArr = newDiffArr;
            n--;
        }

        int minDistance = diffArr[1];
        for (int diff : diffArr) {
            if (diff == 0) continue;
            minDistance = Math.min(minDistance, diff);
        }
        return minDistance;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(25, new int[]{2, 14, 11, 21, 17}, 2)); // 4
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 1)); // 3
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 2)); // 4
        System.out.println(s.solution(25, new int[]{3, 6, 10, 15, 23}, 3)); // 6
    }
}
