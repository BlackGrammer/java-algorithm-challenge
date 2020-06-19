package org.blackgrammer.graph.problem4;


import java.util.Arrays;

/**
 * 방의 개수 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49190">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] arrows) {
        int arrowCnt = arrows.length;
        int[] point = new int[2];
        boolean[][] visitNode = new boolean[arrowCnt * 2][arrowCnt * 2];
        int[][] visitEdge = new int[arrowCnt * 2][arrowCnt * 2];
        for (int[] edge : visitEdge) {
            Arrays.fill(edge, -1);
        }
        Arrays.fill(point, arrowCnt);
        visitNode[arrowCnt][arrowCnt] = true;

        int answer = 0;
        for (int arrow : arrows) {
            move(point, arrow);
            // TODO: edge
            if ((visitNode[point[0]][point[1]] )
                    && visitEdge[point[0]][point[1]] != arrow) {
                visitEdge[point[0]][point[1]] = arrow;
                answer++;
            } else {
                visitNode[point[0]][point[1]] = true;
                visitEdge[point[0]][point[1]] = arrow;
            }
        }

        return answer;
    }

    public void move(int[] currPoint, int caseNum) {
        int moveX = 0;
        int moveY = 0;
        if (caseNum % 4 != 0) {
            moveX = caseNum / 4 == 1 ? -1 : 1;
        }
        if ((caseNum + 2) % 4 != 0) {
            moveY = caseNum / 4 == 1 ? -1 : 1;
        }
        currPoint[0] += moveX;
        currPoint[1] += moveY;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0})); // 3
        System.out.println(s.solution(new int[]{6, 5, 2, 7, 1, 4, 2, 4, 6})); // 3
        System.out.println(s.solution(new int[]{5, 2, 7, 1, 6, 3})); // 3
        System.out.println(s.solution(new int[]{6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0})); // 3
    }

}
