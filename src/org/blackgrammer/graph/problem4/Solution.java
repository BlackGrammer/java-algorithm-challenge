package org.blackgrammer.graph.problem4;


import java.util.Arrays;

/**
 * 방의 개수 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49190">프로그래머스</a>
 */
public class Solution {
    // TODO : 방의 개수 문제 보류..
    public int solution(int[] arrows) {
        int arrowCnt = arrows.length;
        int[] point = new int[2];
        int[][] visitNode = new int[arrowCnt * 2][arrowCnt * 2];
        boolean[][] visitEdge = new boolean[arrowCnt * 2][arrowCnt * 2];
        Arrays.fill(point, arrowCnt);
        int nodeSequence = 0;
        visitNode[arrowCnt][arrowCnt] = ++nodeSequence;

        int answer = 0;
        int[] prev = new int[2];
        for (int arrow : arrows) {
            prev[0] = point[0];
            prev[1] = point[1];
            move(point, arrow);

            int pointNodeNum = visitNode[point[0]][point[1]];
            int prevNodeNum = visitNode[prev[0]][prev[1]];
            int[] tmpEdge = new int[]{prevNodeNum, pointNodeNum};
            Arrays.sort(tmpEdge);
            if (pointNodeNum > 0 && !visitEdge[tmpEdge[0]][tmpEdge[1]]) answer++;

            boolean isDiagonal = arrow % 2 == 1;
            if (isDiagonal) {
                int[] its1 = createArrWithMove(prev, (arrow + 1) % 8);
                int[] its2 = createArrWithMove(prev, (arrow + 7) % 8);
                int itsNodeNum1 = visitNode[its1[0]][its1[1]];
                int itsNodeNum2 = visitNode[its2[0]][its2[1]];
                int[] tmpItsEdge = new int[]{itsNodeNum1, itsNodeNum2};
                Arrays.sort(tmpItsEdge);
                if (itsNodeNum1 * itsNodeNum2 > 0 && visitEdge[tmpItsEdge[0]][tmpItsEdge[1]]) answer++;
            }

            if (visitNode[point[0]][point[1]] == 0) {
                visitNode[point[0]][point[1]] = ++nodeSequence;
                visitEdge[prevNodeNum][nodeSequence] = true;
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
        System.out.println(s.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0})); // 3
        System.out.println(s.solution(new int[]{6, 5, 2, 7, 1, 4, 2, 4, 6})); // 3
        System.out.println(s.solution(new int[]{5, 2, 7, 1, 6, 3})); // 3
        System.out.println(s.solution(new int[]{6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0})); // 3
    }

}
