package org.blackgrammer.stack.problem1;

/**
 * 탑 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42588">
 */
public class Solution {

    public int[] solution(int[] heights) {

        int answer[] = new int[heights.length];

        for (int startNode = heights.length - 1; startNode > 0; startNode--) {
            for (int targetNode = startNode - 1; targetNode >= 0; targetNode--) {
                if (heights[targetNode] > heights[startNode]) {
                    answer[startNode] = targetNode + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
