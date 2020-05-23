package org.blackgrammer.greedy.problem4;


import java.util.Arrays;

/**
 * 구명보트 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42885">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] lefts = new boolean[people.length];
        int boatCnt = 0;
        int leftCnt = 0;
        int curr = 0;
        int max = people.length;

        while (leftCnt < people.length) {
            int target = people[curr];
            boolean possibleFlag = false;

            if (!lefts[curr]) {
                lefts[curr] = true;
                leftCnt++;
                boatCnt++;

                for (int i = max - 1; i > curr; i--) {
                    lefts[i] = true;
                    leftCnt++;
                    max = i;
                    if (target + people[i] <= limit) {
                        possibleFlag = true;
                        break;
                    }
                    boatCnt++;
                }
            }

            if (!possibleFlag) {
                for (boolean left : lefts) {
                    if (!left) boatCnt++;
                }
                break;
            }
            curr++;
        }

        return boatCnt;
    }

}
