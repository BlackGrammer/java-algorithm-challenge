package org.blackgrammer.graph.problem3;


import java.util.*;

/**
 * 사이클 제거 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49188">프로그래머스</a>
 */
public class Solution {
    // TODO : 사이클제거 문제 시간복잡도 해결필요
    public int solution(int n, int[][] edges) {
        int edgeCnt = edges.length;
        boolean[] edgeMarker = new boolean[edgeCnt];
        boolean[] nodeMarker = new boolean[n + 1];
        boolean[] intersection = new boolean[n + 1];
        int intersectionNodeSum = n * (n + 1) / 2;
        Arrays.fill(intersection, true);
        Stack<Integer> nodeStack = new Stack<>();
        boolean[] cycleNodeGroup = new boolean[n + 1];

        nodeStack.push(1);
        nodeMarker[1] = true;
        while (!nodeStack.isEmpty() && intersectionNodeSum > 0) {
            int start = nodeStack.peek();
            boolean isCycle = false;
            for (int edgeIdx = 0; edgeIdx < edgeCnt; edgeIdx++) {
                // 방문한 노드 pass
                if (edgeMarker[edgeIdx]) continue;

                int[] targetEdge = edges[edgeIdx];
                int node_1 = targetEdge[0];
                int node_2 = targetEdge[1];

                // 대상 node 의 edge 아니면 pass
                if (node_1 != start && node_2 != start) continue;

                int targetNode = node_1 == start ? node_2 : node_1;
                edgeMarker[edgeIdx] = true;
                cycleNodeGroup[start] = true;
                cycleNodeGroup[targetNode] = true;

                // cycle 발견
                if (nodeMarker[targetNode]) {
                    for (int nodeIdx = 1; nodeIdx <= n; nodeIdx++) {
                        if (!intersection[nodeIdx]) continue;
                        boolean isIntersected = intersection[nodeIdx] && cycleNodeGroup[nodeIdx];
                        intersection[nodeIdx] = isIntersected;
                        if (!isIntersected) intersectionNodeSum -= nodeIdx;
                    }
                    Arrays.fill(cycleNodeGroup, false);
                    isCycle = true;
                    break;
                } else {
                    nodeStack.push(targetNode);
                    nodeMarker[targetNode] = true;
                    break;
                }
            }
            if (start == nodeStack.peek() && !isCycle) {
                cycleNodeGroup[start] = false;
                nodeStack.pop();
            }
        }
        return intersectionNodeSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}})); // 5
        System.out.println(s.solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}})); // 0
    }

}
