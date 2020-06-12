package org.blackgrammer.dynamic.problem7;


import java.util.*;

/**
 * 서울에서 경산까지 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42899">프로그래머스</a>
 */
public class Solution {
    public int solution(int K, int[][] travel) {
        Arrays.sort(travel, (prev, next) -> (next[1] - next[3]) * (prev[0] - prev[2]) - (prev[1] - prev[3]) * (next[0] - next[2]));
        int totalTime = 0;
        int totalRaise = 0;

        Stack<int[]> pavementStack = new Stack<>();
        for (int[] route : travel) {
            if (totalTime + route[0] <= K) {
                totalTime += route[0];
                totalRaise += route[1];
                pavementStack.push(route);
            } else {
                if (totalTime + route[2] <= K) {
                    totalTime += route[2];
                    totalRaise += route[3];
                } else {
                    while (true) {
                        int[] prevRoute = pavementStack.pop();
                        totalTime -= (prevRoute[0] - prevRoute[2]);
                        totalRaise -= (prevRoute[1] - prevRoute[3]);
                        if (totalTime + route[0] <= K) {
                            totalTime += route[0];
                            totalRaise += route[1];
                            pavementStack.push(route);
                            break;
                        } else if (totalTime + route[2] <= K) {
                            totalTime += route[2];
                            totalRaise += route[3];
                            break;
                        }
                    }
                }
            }
        }

        return totalRaise;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1650, new int[][]{{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}})); // 660
        System.out.println(s.solution(3000, new int[][]{{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}})); // 5900
    }


}
