package org.blackgrammer.dynamic.problem4;


import java.util.Arrays;

/**
 * 등굣길 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42898">프로그래머스</a>
 */
public class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] nodes = new int[m][n];
        for (int[] node : nodes) {
            Arrays.fill(node, m * n);
        }
        nodes[0][0] = 0;
        for (int[] puddle : puddles) {
            nodes[puddle[0] - 1][puddle[1] - 1] = -1;
        }

        return getRounteCnt(m, n, 0, 0, nodes, 0);
    }

    private int getRounteCnt(int width, int height, int currCol, int currRow, int[][] nodes, int prevCnt) {
        int left = currCol - 1;
        int right = currCol + 1;
        int up = currRow - 1;
        int down = currRow + 1;

        int cnt = prevCnt;

        if (currCol > 0) {
            int leftAccum = nodes[left][currRow];
            int currAccum = nodes[currCol][currRow];
            if (leftAccum >= currAccum + 1) {
                if (leftAccum == currAccum + 1) {
                    cnt++;
                } else {
                    nodes[left][currRow] = currAccum + 1;
                    cnt = getRounteCnt(width, height, left, currRow, nodes, cnt);
                }
            }
        }

        if (currCol < width - 1) {
            int rightAccum = nodes[right][currRow];
            int currAccum = nodes[currCol][currRow];
            if (rightAccum >= currAccum + 1) {
                if (rightAccum == currAccum + 1) {
                    cnt++;
                } else {
                    nodes[right][currRow] = currAccum + 1;
                    if (right == width - 1 && currRow == height - 1) cnt = 1;
                    else cnt = getRounteCnt(width, height, right, currRow, nodes, cnt);
                }
            }
        }

        if (currRow > 0) {
            int upAccum = nodes[currCol][up];
            int currAccum = nodes[currCol][currRow];
            if (upAccum >= currAccum + 1) {
                if (upAccum == currAccum + 1) {
                    cnt++;
                } else {
                    nodes[currCol][up] = currAccum + 1;
                    cnt = getRounteCnt(width, height, currCol, up, nodes, cnt);
                }
            }
        }

        if (currRow < height - 1) {
            int downAccum = nodes[currCol][down];
            int currAccum = nodes[currCol][currRow];
            if (downAccum >= currAccum + 1) {
                if (downAccum == currAccum + 1) {
                    cnt++;
                } else {
                    nodes[currCol][down] = currAccum + 1;
                    if (currCol == width - 1 && down == height - 1) cnt = 1;
                    else cnt = getRounteCnt(width, height, currCol, down, nodes, cnt);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }
}
