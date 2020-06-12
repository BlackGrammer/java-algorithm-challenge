package org.blackgrammer.dynamic.problem7;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 서울에서 경산까지 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42899">프로그래머스</a>
 */
public class Solution {
    public int solution(int K, int[][] travel) {
        Queue<int[]> routeQueue = new ArrayDeque<>();
        routeQueue.offer(new int[]{travel[0][0], travel[0][1]});
        routeQueue.offer(new int[]{travel[0][2], travel[0][3]});

        for (int i = 1, len = travel.length; i < len; i++) {
            int[] target = travel[i];
            for (int i2 = 0, routeQueueCnt = routeQueue.size(); i2 < routeQueueCnt; i2++) {
                int[] prev = routeQueue.poll();
                if (prev[0] + target[0] <= K) {
                    routeQueue.offer(new int[]{prev[0] + target[0], prev[1] + target[1]});
                }
                if (prev[0] + target[2] <= K) {
                    routeQueue.offer(new int[]{prev[0] + target[2], prev[1] + target[3]});
                }
            }
        }

        int maxRaise = 0;
        while(!routeQueue.isEmpty()) {
            maxRaise = Math.max(routeQueue.poll()[1], maxRaise);
        }

        return maxRaise;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1650, new int[][]{{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}})); // 660
        System.out.println(s.solution(3000, new int[][]{{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}})); // 5900
    }


}
