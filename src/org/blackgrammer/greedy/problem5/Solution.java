package org.blackgrammer.greedy.problem5;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 섬 연결하기 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42861">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] costs) {

        boolean[] connect = new boolean[n];
        int connectionCnt = 1;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        int answer = 0;
        connect[costs[0][0]] = true;
        while (connectionCnt < n) {
            int minCost = Integer.MAX_VALUE;
            int selectedNode = 0;
            for (int[] cost : costs) {
                int to = cost[0];
                int from = cost[1];
                if (connect[to] && connect[from]) continue;
                if (!connect[to] && !connect[from]) continue;

                if(minCost > cost[2]) {
                    minCost = cost[2];
                    if(!connect[to]) selectedNode = to;
                    if(!connect[from]) selectedNode = from;
                }
            }
            connectionCnt++;
            connect[selectedNode] = true;
            answer += minCost;
        }

        return answer;
    }

}
