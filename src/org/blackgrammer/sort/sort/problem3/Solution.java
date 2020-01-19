package org.blackgrammer.sort.sort.problem3;

import java.util.Arrays;

/**
 * H-Index _ 프로그래머스 _ 정렬
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42747">프로그래머스</a>
 */

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int length = citations.length, i = length; i > 0; i--) {
            int targetRepeat = citations[i - 1];
            int order = length - i + 1;
            if (targetRepeat == order) {
                return order;
            }
            if (targetRepeat < order) {
                return order == 1 ? targetRepeat : order - 1;
            }
        }
        return citations.length;
    }
}
