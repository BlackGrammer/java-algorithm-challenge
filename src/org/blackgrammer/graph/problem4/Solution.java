package org.blackgrammer.graph.problem4;



/**
 * 방의 개수 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49190">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] arrows) {
        int x = 0;
        int y = 0;
        int arrowCnt = arrows.length;
        int[][] visitNode = new int[arrowCnt][arrowCnt];
        int[][] visitEdge = new int[arrowCnt][arrowCnt];

        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }

}
