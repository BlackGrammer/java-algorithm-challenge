package org.blackgrammer.dynamic.problem6;


/**
 * 도둑질 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42897">프로그래머스</a>
 */
public class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] robbed = new int[len];
        int max = 0;
        int i = 2;
        robbed[0] = money[0];
        robbed[1] = Math.max(money[1], robbed[0]);

        while (true) {
            if (i == len - 1) {
                max = robbed[i - 1];
                robbed[len - 1] = money[len - 1];
                robbed[0] = Math.max(money[0], robbed[len - 1]);
                i += 2;
                continue;
            }

            if (i  == 2* len - 2) break;
            robbed[i % len] = Math.max(robbed[(i - 1) % len], money[i % len] + robbed[(i - 2) % len]);
            i++;
        }

        return Math.max(robbed[len - 3], max);
    }

}
