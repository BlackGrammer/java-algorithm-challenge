package org.blackgrammer.graph.problem1;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 가장 먼 노드 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49189">프로그래머스</a>
 */
public class Solution {
    public int solution(int n, int[][] edges) {
        int[] distances = new int[n];

        Queue<Integer> nextNodes = new ArrayDeque<>();
        nextNodes.offer(1);
        int max = 0;
        int cnt = 0;
        while (!nextNodes.isEmpty()) {
            int curr = nextNodes.poll();
            for (int[] edge : edges) {
                int target;
                if (edge[0] == curr) target = edge[1];
                else if (edge[1] == curr) target = edge[0];
                else continue;

                if (target == 1) continue;
                if (distances[target - 1] != 0) continue;
                int newDistance = distances[curr - 1] + 1;
                distances[target - 1] = newDistance;
                if (newDistance > max) {
                    max = newDistance;
                    cnt = 1;
                } else if (newDistance == max) cnt++;
                nextNodes.offer(target);
            }
        }

        return cnt;
    }
}
