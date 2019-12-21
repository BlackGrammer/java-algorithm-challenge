package org.blackgrammer.sort.sort.problem1;


import java.util.Arrays;

/**
 *  k번째 수 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42748">프로그래머스</a>
 */

public class Solution {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int answerIdx = 0;

        int[] tmpArr;
        for(int[] command : commands) {
            tmpArr = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(tmpArr);
            answer[answerIdx] = tmpArr[command[2]-1];
            answerIdx++;
        }

        return answer;
    }

}
