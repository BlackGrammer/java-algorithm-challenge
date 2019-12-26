package org.blackgrammer.sort.sort.problem2;

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
            int pos1 = 0;
            int pos2 = 0;
            boolean firstOutbound = false;
            boolean secondOutbound = false;

            while (true) {
                char ch1 = firstOutbound ? str1.charAt(0) : str1.charAt(pos1);
                char ch2 = secondOutbound ? str2.charAt(0) : str2.charAt(pos2);

                if (ch1 == ch2) {
                    if (pos1 + 1 < str1.length()) pos1++;
                    else firstOutbound = true;
                    if (pos2 + 1 < str2.length()) pos2++;
                    else secondOutbound = true;

                    if (firstOutbound && secondOutbound) return str2.length() - str1.length();
                    continue;
                }
                return ch2 - ch1;
            }
        });

        StringBuilder answer = new StringBuilder();
        for (String str : strList) {
            answer.append(str);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
//            [3, 30, 34, 33, 5, 9]
//        "953433330"

//                [3, 30, 34, 5, 9]
//        "9534330"
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 30, 34, 33, 5, 9}));
    }
}
