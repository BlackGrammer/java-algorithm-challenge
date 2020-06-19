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
        int[] prev = new int[2];
        for (int arrow : arrows) {
            prev[0] = point[0];
            prev[1] = point[1];
            move(point, arrow);
            System.out.println("arrow = " + arrow);
            System.out.println("Arrays.toString(point) = " + Arrays.toString(point));
            if (visitNode[point[0]][point[1]] && visitEdge[point[0]][point[1]] != arrow && ((visitEdge[prev[0]][prev[1]]) + 4) % 8 != arrow) {
                answer++;
            }

            boolean isDiagonal = arrow % 2 == 1;
            if (isDiagonal) {
                int[] target = createArrWithMove(prev, (arrow + 1) % 8);
                if (visitNode[target[0]][target[1]] && visitEdge[target[0]][target[1]] == (arrow + 2) % 8) {
                    answer++;
                } else {
                    target = createArrWithMove(prev, (arrow + 7) % 8);
                    if (visitNode[target[0]][target[1]] && visitEdge[target[0]][target[1]] == (arrow + 6) % 8) {
                        answer++;
                    }
                }
            }
            System.out.println("answer = " + answer);
            System.out.println("---------------------");

            visitEdge[point[0]][point[1]] = arrow;
            visitNode[point[0]][point[1]] = true;
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
            moveY = (caseNum + 2) / 4 == 1 ? -1 : 1;
        }
        currPoint[0] += moveX;
        currPoint[1] += moveY;
    }

    public int[] createArrWithMove(int[] currPoint, int caseNum) {
        int[] newArr = new int[2];
        newArr[0] = currPoint[0];
        newArr[1] = currPoint[1];
        move(newArr, caseNum);

        return newArr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0})); // 3
        System.out.println(s.solution(new int[]{6, 5, 2, 7, 1, 4, 2, 4, 6})); // 3
//        System.out.println(s.solution(new int[]{5, 2, 7, 1, 6, 3})); // 3
//        System.out.println(s.solution(new int[]{6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0})); // 3
    }

}
