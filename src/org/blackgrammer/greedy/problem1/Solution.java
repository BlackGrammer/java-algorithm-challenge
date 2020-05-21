package org.blackgrammer.greedy.problem1;

import java.util.*;

/**
 * 체육복 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42862">프로그래머스</a>
 */
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n;

        List<Integer> sameNumList = new ArrayList<>();
        for (int los : lost) {
            for (int res : reserve) {
                if (res == los) {
                    sameNumList.add(res);
                    break;
                }
                if (res > los) break;
            }
        }

        List<Integer> prevResList = new ArrayList<>();
        for (int los : lost) {
            if (sameNumList.contains(los)) continue;
            boolean getFlag = false;

            for (int res : reserve) {
                if (sameNumList.contains(res) || prevResList.contains(res)) continue;
                if (Math.abs(res - los) == 1) {
                    getFlag = true;
                    prevResList.add(res);
                    break;
                }
            }

            if (!getFlag) answer--;
        }
        return answer;
    }

}
