package org.blackgrammer.bruteforce.problem2;

import java.util.*;

/**
 * 소수찾기 _ 프로그래머스 _ 완전탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42839">프로그래머스</a>
 */

public class Solution {

    public int solution(String numbers) {
        List<String> numberList = Arrays.asList(numbers.split(""));
        Set<Integer> decimalList = new HashSet<>();
        getDecimalAndAdd(numberList, decimalList, "");
        for (Integer decimal : decimalList) {
            System.out.println(decimal);
        }
        return decimalList.size();
    }

    private void getDecimalAndAdd(List<String> numberList, Set<Integer> decimalList, String prevNumber) {
        int index = 0;
        for (String number : numberList) {
            List<String> cloneNumberList = new ArrayList<>(numberList);
            cloneNumberList.remove(index);
            String newPrevNumber = number + prevNumber;
            if (isDecimal(number, prevNumber)) {
                decimalList.add(Integer.parseInt(newPrevNumber));
            }
            getDecimalAndAdd(cloneNumberList, decimalList, newPrevNumber);
            index++;
        }
    }

    private boolean isDecimal(String number, String privateDecimal) {
        Integer target = privateDecimal.isEmpty() ? Integer.parseInt(number) : Integer.parseInt(number + privateDecimal);
        if (target.equals(0) || target.equals(1)) return false;
        if (target.equals(2)) return true;
        int count = 1;
        for (int i = 2, max = target / 2; i <= max; i++) {
            if (target % i == 0) count++;
            if (count >= 2) return false;
        }
        return true;
    }


}
