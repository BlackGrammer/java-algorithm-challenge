package org.blackgrammer.graph.problem3;


import java.util.*;

/**
 * 사이클 제거 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49188">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] edges) {

        int notValid = 0;
        int edgeCnt = edges.length;
        Stack<Integer> nodeStack;
        boolean[] visitNodes;
        boolean[] visitEdges;

        for (int remove = 1; remove <= n; remove++) {
            // stack, marker 초기화
            nodeStack = new Stack<>();
            visitNodes = new boolean[n + 1];
            visitEdges = new boolean[edges.length];

            int startNode = ((remove + 1) % n) + 1;
            nodeStack.push(startNode);
            visitNodes[startNode] = true;

            // stack 에 node 쌓아가면서 모든 노드 bfs
            while (!nodeStack.isEmpty()) {
                int bottom = nodeStack.peek();
                boolean isCycle = false;
                for (int edgeIdx = 0; edgeIdx < edgeCnt; edgeIdx++) {
                    // 방문한 edge 는 넘어간다
                    if (visitEdges[edgeIdx]) continue;

                    int[] targetEdge = edges[edgeIdx];
                    int node_1 = targetEdge[0];
                    int node_2 = targetEdge[1];

                    // remove 된 node 의 edge 는 넘어간다
                    if (node_1 == remove || node_2 == remove) {
                        visitEdges[edgeIdx] = true;
                        continue;
                    }
                    if (node_1 == bottom || node_2 == bottom) {
                        int targetNode = node_1 == bottom ? node_2 : node_1;
                        if (visitNodes[targetNode]) {
                            isCycle = true;
                        }
                        visitNodes[targetNode] = true;
                        visitEdges[edgeIdx] = true;
                        nodeStack.push(targetNode);
                        break;
                    }
                }
                if (isCycle) {
                    notValid += remove;
                    break;
                }
                if (nodeStack.peek() == bottom)
                    nodeStack.pop();
            }
        }

        return n * (n + 1) / 2 - notValid;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}})); // 5
        System.out.println(s.solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}})); // 0
    }

}
