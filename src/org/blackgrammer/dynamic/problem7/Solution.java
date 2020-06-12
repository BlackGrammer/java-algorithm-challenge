package org.blackgrammer.dynamic.problem7;


/**
 * 서울에서 경산까지 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42899">프로그래머스</a>
 */
public class Solution {
    public int solution(int K, int[][] travel) {
        int[][] routeArr = new int[travel.length][K + 1];
        int[] first = travel[0];
        routeArr[0][first[0]] = first[1];
        routeArr[0][first[2]] = first[3];

        int maxRaise = 0;
        for (int cityIdx = 1, len = travel.length; cityIdx < len; cityIdx++) {
            int[] target = travel[cityIdx];
            for (int time = 0; time <= K; time++) {
                int prevRaise = routeArr[cityIdx - 1][time];
                if (prevRaise == 0) continue;

                if (time + target[0] <= K) routeArr[cityIdx][time + target[0]] = Math.max(routeArr[cityIdx][time + target[0]], prevRaise + target[1]);
                if (time + target[2] <= K) routeArr[cityIdx][time + target[2]] = Math.max(routeArr[cityIdx][time + target[2]], prevRaise + target[3]);
            }
        }

        for (int time = 0; time <= K; time++) {
            maxRaise = Math.max(maxRaise, routeArr[travel.length - 1][time]);
        }

        return maxRaise;
    }

}
