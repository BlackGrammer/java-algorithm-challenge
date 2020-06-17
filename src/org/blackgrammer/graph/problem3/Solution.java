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
        int edgeCnt = edges.length;
        boolean[][] edgeNodeRelation = new boolean[edgeCnt][n + 1];
        for (int edgeIdx = 0; edgeIdx < edgeCnt; edgeIdx++) {
            int[] targetEdge = edges[edgeIdx];
            edgeNodeRelation[edgeIdx][targetEdge[0]] = true;
            edgeNodeRelation[edgeIdx][targetEdge[1]] = true;
        }


        boolean[] visitEdge;
        boolean[] visitNode;
        Stack<Integer> nodeStack;
        int answer = n * (n + 1) / 2;
        for (int remove = 1; remove <= n; remove++) {
            visitEdge = new boolean[edgeCnt];
            visitNode = new boolean[n + 1];
            nodeStack = new Stack<>();
            int start = (remove + 1) % n + 1;
            visitNode[start] = true;
            nodeStack.push(start);

            boolean isCycle = false;
            while (!nodeStack.isEmpty()) {
                int bottom = nodeStack.peek();
                for (int edgeIdx = 0; edgeIdx < edgeCnt; edgeIdx++) {
                    // 제거한 node 의 edge 라면 continue
                    if (edgeNodeRelation[edgeIdx][remove]) continue;
                    // 방문한 edge 라면 continue
                    if (visitEdge[edgeIdx]) continue;
                    // 대상 node 의 edge 아니면 continue
                    if (!edgeNodeRelation[edgeIdx][bottom]) continue;

                    visitEdge[edgeIdx] = true;
                    int[] targetEdge = edges[edgeIdx];
                    int targetNode = targetEdge[0] == bottom ? targetEdge[1] : targetEdge[0];
                    if (visitNode[targetNode]) {
                        answer -= remove;
                        isCycle = true;
                        break;
                    } else {
                        visitNode[targetNode] = true;
                        nodeStack.push(targetNode);
                    }
                }
                if(isCycle) break;
                if (bottom == nodeStack.peek()) nodeStack.pop();
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}})); // 5
        System.out.println(s.solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}})); // 0
    }

}
