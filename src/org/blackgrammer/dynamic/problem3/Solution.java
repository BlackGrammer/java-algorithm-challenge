package org.blackgrammer.dynamic.problem3;


/**
 * 정수 삼각형 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43105">프로그래머스</a>
 */
public class Solution {

    public int solution(int[][] triangle) {
        int max = 0;

        for (int row = 1, len = triangle.length; row < len; row++) {
            for (int col = 0; col < row + 1; col++) {
                int right = 0;
                if (col < row) right = triangle[row - 1][col];
                int left = 0;
                if (col > 0) left = triangle[row - 1][col - 1];

                if (col == 0) {
                    triangle[row][col] += right;
                    continue;
                }
                if (col == row) {
                    triangle[row][col] += left;
                    continue;
                }

                triangle[row][col] += Math.max(left, right);
                if (row == len - 1) max = Math.max(max, triangle[row][col]);
            }
        }

        return max;
    }

}
