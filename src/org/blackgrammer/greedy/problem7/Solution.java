package org.blackgrammer.greedy.problem7;

import java.util.Arrays;

/**
 * 저울 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42886">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] weight) {
        Arrays.sort(weight);
        int max = 0;
        for (int w : weight) {
            if (w > max + 1) break;
            max += w;
        }
        return max + 1;
    }
}
