package org.blackgrammer.binary.problem2;

import java.util.Arrays;

/**
 * 입국심사 _ 프로그래머스 _ 이분탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43238">프로그래머스</a>
 */
public class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long minTime = 0;
        long maxTime = (long)times[0] * (long)n;
        long target = maxTime / 2;

        while (true) {
            int count = 0;
            long realTime = 0;
            boolean overFlag = false;

            for (int time : times) {
                int rowCnt = (int) (target / time);
                count += rowCnt;
                realTime = Math.max(realTime, (long)rowCnt * (long)time);
                if (count > n) {
                    maxTime = target;
                    target = (minTime + target) / 2;
                    overFlag = true;
                    break;
                }
            }

            if (overFlag) continue;
            if (count == n) {
                target = realTime;
                break;
            }

            minTime = target;
            target = (maxTime + target) / 2;
        }
        return target;
    }
}
