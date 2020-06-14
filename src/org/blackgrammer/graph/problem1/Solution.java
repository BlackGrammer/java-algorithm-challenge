package org.blackgrammer.graph.problem1;


/**
 * 가장 먼 노드 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49189">프로그래머스</a>
 */
public class Solution {
    public int solution(int n, int[][] edges) {
        int[] distances = new int[n];
        findMaxDistanceNodes(edges, distances, 1);

        int max = 0;
        int cnt = 0;
        for (int distance : distances) {
            if (distance > max) {
                max = distance;
                cnt = 1;
            } else if (distance == max) {
                cnt++;
            }
        }
        return cnt;
    }

    public void findMaxDistanceNodes(int[][] edges, int[] distances, int curr) {
        for (int[] edge : edges) {
            int target;
            if (edge[0] == curr) target = edge[1];
            else if (edge[1] == curr) target = edge[0];
            else continue;

            if (target == 1) continue;
            if (distances[target - 1] > distances[curr - 1] + 1 || distances[target - 1] == 0) {
                distances[target - 1] = distances[curr - 1] + 1;
                findMaxDistanceNodes(edges, distances, target);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3,}, {1, 2}, {2, 4}, {5, 2}})); // 3
    }
}
