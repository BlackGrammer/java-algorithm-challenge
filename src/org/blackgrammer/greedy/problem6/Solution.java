package org.blackgrammer.greedy.problem6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속카메 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42884">프로그래머스</a>
 */
public class Solution {

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[0]));

        int tmpPos = routes[0][1];
        int cnt = 1;

        for (int i = 1, len = routes.length; i < len; i ++) {
            int start =routes[i][0];
            int end = routes[i][1];
            if(start > tmpPos) {
                cnt++;
                tmpPos =  end;
            } else {
                if(end < tmpPos) {
                    tmpPos = end;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
