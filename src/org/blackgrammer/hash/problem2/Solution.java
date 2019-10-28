package org.blackgrammer.hash.problem2;

/**
 * 전화번호 목록 _ 프로그래머스 _ 해시
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42576">프로그래머스</a>
 */
public class Solution {

    public boolean solution(String[] phone_book) {

        for (int bookIndex = 0; bookIndex < phone_book.length - 1; bookIndex++) {

            // 왼쪽 비교 기준
            String currentTarget = phone_book[bookIndex];

            for (int rightIndex = bookIndex + 1; rightIndex < phone_book.length; rightIndex++) {

                // 오른쪽 비교 기준
                String rightTarget = phone_book[rightIndex];

                // 접두어 여부 체크 횟수 줄이기 위해 길이 비교
                boolean isCurrentBigger = currentTarget.length() > rightTarget.length();

                // 문자열 길이 비교
                if (isCurrentBigger) {
                    if (currentTarget.substring(0,rightTarget.length()).equals(rightTarget)) return false;
                } else {
                    if (rightTarget.substring(0, currentTarget.length()).equals(currentTarget)) return false;
                }
            }
        }

        return true;
    }
}
