package org.blackgrammer.dynamic.problem5;


/**
 * 카드게임 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42896">프로그래머스</a>
 */
public class Solution {
    public int solution(int[] left, int[] right) {
        int[][] store = new int[left.length + 1][right.length + 1];

        for (int i = left.length - 1; i >= 0; i--) {
            for (int j = right.length - 1; j >= 0; j--) {
                if (left[i] > right[j]) store[i][j] = store[i][j + 1] + right[j];
                else store[i][j] = Math.max(store[i + 1][j], store[i + 1][j + 1]);
            }
        }
        return store[0][0];
    }
}
