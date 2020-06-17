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
        Stack<Integer> nodeStack;
        Set<Integer> cycleGroup = new HashSet<>();
        boolean[][] visitEdges;
        boolean[] possible = new boolean[n + 1];
        Arrays.fill(possible, true);

        // stack, marker 초기화
        nodeStack = new Stack<>();
        visitEdges = new boolean[n + 1][n + 1];

        nodeStack.push(1);
        cycleGroup.add(1);

        // stack 에 node 쌓아가면서 모든 노드 bfs
        while (!nodeStack.isEmpty()) {
            int bottom = nodeStack.peek();

            for (int edgeIdx = 0; edgeIdx < edgeCnt; edgeIdx++) {

                int[] targetEdge = edges[edgeIdx];
                int node_1 = targetEdge[0];
                int node_2 = targetEdge[1];

                if (node_1 == bottom || node_2 == bottom) {
                    int targetNode = node_1 == bottom ? node_2 : node_1;

                    // 방문한 방향의 edge 는 넘어간다
                    if (visitEdges[bottom][targetNode]) continue;
                    visitEdges[bottom][targetNode] = true;
                    if (!cycleGroup.add(targetNode)) {
                        System.out.println("bottom = " + bottom);
                        System.out.println("targetNode = " + targetNode);
                        // 사이클 발견
                        // 기존 사이클과 그룹과 비교하여 중복되는 노드만 남기기
                        // 사이클을 구성하는 노드의 최소 그룹 구해야한다
                        Stack<Integer> tmpStack = new Stack<>();
                        while (true) {
                            int prevNode = nodeStack.pop();
                            tmpStack.push(prevNode);
                            if (prevNode == targetNode) break;
                        }
                        boolean[] tmpGroup = new boolean[n + 1];
                        while (!tmpStack.isEmpty()) {
                            int groupNum = tmpStack.pop();
                            tmpGroup[groupNum] = true;
                            nodeStack.push(groupNum);
                        }

                        System.out.println("possible = " + Arrays.toString(possible));
                        System.out.println("tmpGroup" + Arrays.toString(tmpGroup));
                        for (int groupNode = 1; groupNode < n; groupNode++) {
                            possible[groupNode] = possible[groupNode] && tmpGroup[groupNode];
                        }
                        continue;
                    } else {
                        nodeStack.push(targetNode);
                    }
                    break;
                }
            }

            if (nodeStack.peek() == bottom) {
                nodeStack.pop();
                cycleGroup.remove(bottom);
            }

        }

        // posiible 돌면서 연산후 return
        int answer = 0;
        for (int nodeIdx = 1; nodeIdx < n; nodeIdx++) {
            if (possible[nodeIdx]) answer += nodeIdx;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}})); // 5
        System.out.println(s.solution(8, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6}})); // 0
    }

}
