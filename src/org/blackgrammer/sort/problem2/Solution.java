package org.blackgrammer.sort.problem2;

import java.util.*;

/**
 * 가장 큰 수 _ 프로그래머스 _ 정렬
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42746">프로그래머스</a>
 */

public class Solution {

    public String solution(int[] numbers) {
        List<String> strList = new ArrayList<>();

        for (int number : numbers) {
            strList.add(String.valueOf(number));
        }

        strList.sort((str1, str2) -> {
            String comb1 = str1 + str2;
            String comb2 = str2 + str1;
            return Integer.parseInt(comb2) - Integer.parseInt(comb1);
        });

        StringBuilder answer = new StringBuilder();
        for (String str : strList) {
            answer.append(str);
        }

        if (answer.charAt(0) == '0') return "0";

        return answer.toString();
    }

}
