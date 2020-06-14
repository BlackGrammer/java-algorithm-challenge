package org.blackgrammer.graph.problem1;


import java.util.*;

/**
 * 가장 먼 노드 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49189">프로그래머스</a>
 */
public class Solution {
    public int solution(int n, int[][] edges) {
        int[] distances = new int[n];
        Map<Integer, Set<Integer>> vMap = new HashMap<>();

        for (int[] edge : edges) {
            if (vMap.get(edge[0]) == null) vMap.put(edge[0], new HashSet<>());
            if (vMap.get(edge[1]) == null) vMap.put(edge[1], new HashSet<>());
            if (edge[1] != 1) vMap.get(edge[0]).add(edge[1]);
            if (edge[0] != 1) vMap.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> nextNodes = new ArrayDeque<>();
        nextNodes.offer(1);

        int max = 0;
        int cnt = 0;
        while (!nextNodes.isEmpty()) {
            int curr = nextNodes.poll();
            Iterator<Integer> it = vMap.get(curr).iterator();
            while (it.hasNext()) {
                int target = it.next();
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
