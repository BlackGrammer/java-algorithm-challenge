package org.blackgrammer.graph.problem2;


/**
 * 순위 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49191">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] results) {
        boolean[][] edge = new boolean[n + 1][n + 1];
        int[] cntArr = new int[n + 1];
        int cnt = 0;
        for (int[] result : results) {
            edge[result[0]][result[1]] = true;
            if (++cntArr[result[0]] == n - 1) cnt++;
            if (++cntArr[result[1]] == n - 1) cnt++;
            for (int idx = 1; idx <= n; idx++) {
                if (edge[idx][result[0]] && !edge[idx][result[1]]) {
                    edge[idx][result[1]] = true;
                    if (++cntArr[idx] == n - 1) cnt++;
                    if (++cntArr[result[1]] == n - 1) cnt++;
                }
                if (edge[result[1]][idx] && !edge[result[0]][idx]) {
                    edge[result[0]][idx] = true;
                    if (++cntArr[idx] == n - 1) cnt++;
                    if (++cntArr[result[0]] == n - 1) cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})); //2
        System.out.println(s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}, {1, 4}}));// 5
    }

}
