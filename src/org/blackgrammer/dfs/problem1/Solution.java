package org.blackgrammer.dfs.problem1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 타겟 넘버 _ 프로그래머스 _ 깊이/너비 우선 탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43165">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] numbers, int target) {
        // 전체합 계산
        int totalSum = 0;
        for (int number : numbers) {
            totalSum += number;
        }

        // loop 문 돌면서 해당 숫자 * 2 빼면서 체크
        AtomicInteger answer = new AtomicInteger();
        getPossibleCase(totalSum, target, numbers, 0, answer);

        return answer.get();
    }

    private void getPossibleCase(int totalSum, int target, int[] numbers, int index, AtomicInteger answer) {

        int afterSum = totalSum - numbers[index] * 2;
        if (afterSum == target) {
            answer.incrementAndGet();
        }

        if (index == numbers.length - 1) return;
        index++;

        if (afterSum > target) {
            getPossibleCase(afterSum, target, numbers, index, answer);
        }
        if (totalSum > target) {
            getPossibleCase(totalSum, target, numbers, index, answer);
        }
    }

}
