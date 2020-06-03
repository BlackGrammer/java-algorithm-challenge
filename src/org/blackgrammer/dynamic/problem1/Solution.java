package org.blackgrammer.dynamic.problem1;

import java.util.*;

/**
 * N으로 표현 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42895">프로그래머스</a>
 */
public class Solution {

    public int solution(int N, int number) {
        if (N == number) return 1;
        Map<Integer, Set<Integer>> caseStore = new HashMap<>();
        caseStore.put(1, new HashSet<>(Collections.singletonList(N)));

        for (int i = 2; i <= 8; i++) {
            Set<Integer> newCaseArr = new HashSet<>();
            for (int i2 = 1; i2 <= i / 2; i2++) {
                for (int prevCase1 : caseStore.get(i2)) {
                    for (int prevCase2 : caseStore.get(i - i2)) {
                        int plusResult = prevCase1 + prevCase2;
                        if (plusResult == number) return i;
                        newCaseArr.add(plusResult);

                        int minusResult = prevCase1 - prevCase2;
                        if (minusResult == number) return i;
                        newCaseArr.add(minusResult);

                        int reverseMinusResult = prevCase2 - prevCase1;
                        if (reverseMinusResult == number) return i;
                        newCaseArr.add(reverseMinusResult);

                        int multiplyResult = prevCase1 * prevCase2;
                        if (multiplyResult == number) return i;
                        newCaseArr.add(multiplyResult);

                        if (prevCase2 != 0) {
                            int divideResult = prevCase1 / prevCase2;
                            if (divideResult == number) return i;
                            newCaseArr.add(divideResult);
                        }

                        if (prevCase1 != 0) {
                            int reverseDivideResult = prevCase2 / prevCase1;
                            if (reverseDivideResult == number) return i;
                            newCaseArr.add(reverseDivideResult);
                        }
                    }
                }
            }

            int accumVal = Integer.parseInt(String.valueOf(N).repeat(i));
            if (accumVal == number) return i;
            newCaseArr.add(accumVal);
            caseStore.put(i, newCaseArr);
        }
        return -1;
    }

}
