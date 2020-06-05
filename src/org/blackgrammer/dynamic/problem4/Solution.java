package org.blackgrammer.dynamic.problem4;


/**
 * 등굣길 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42898">프로그래머스</a>
 */
public class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] nodes = new int[m][n];
        for (int[] puddle : puddles) {
            nodes[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (col == 0 && row == 0) {
                    nodes[col][row] = 1;
                } else {
                    if (nodes[col][row] == -1) continue;
                    if (col > 0) nodes[col][row] += Math.max(nodes[col - 1][row], 0);
                    if (row > 0) nodes[col][row] += Math.max(nodes[col][row - 1], 0);
                    nodes[col][row] %= 1000000007;
                }
            }
        }

        return nodes[m - 1][n - 1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }
}
