package org.blackgrammer.bruteforce.problem2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 소수찾기 _ 프로그래머스 _ 완전탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42839">프로그래머스</a>
 */

public class Solution {

    public int solution(String numbers) {

        int size = numbers.length();
        Set<Integer> decimalStore = new HashSet<>();

        for (int length = 1; length <= size; length++) {
            decimalStore.addAll(getDecimalNumList(numbers, length));
        }

        return decimalStore.size();
    }

    private List<Integer> getDecimalNumList(String numbers, int length) {
        List<Integer> decimalNumList = new ArrayList<>();
        for (int idx = 0, size = numbers.length(); idx < size; idx++) {

        }

        return decimalNumList;
    }


}
