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
        long target = maxTime / 2L;

        while (true) {
            long count = 0;
            long realTime = 0;
            boolean overFlag = false;

            for (long time : times) {
                long rowCnt = target / time;
                count += rowCnt;
                realTime = Math.max(realTime, rowCnt * time);
                if (count > n) {
                    maxTime = target;
                    target = (minTime + target) / 2L;
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
            target = (maxTime + target) / 2L;
        }
        return target;
    }
}
