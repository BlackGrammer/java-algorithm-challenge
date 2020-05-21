package org.blackgrammer.greedy.problem2;


/**
 * 큰 수 만들기 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42883">프로그래머스</a>
 */
public class Solution {

    public String solution(String number, int k) {
        int length = number.length();
        int maxIdx = 0;
        int remain = length - k;
        char[] answerArr = new char[remain];

        while(true) {
            for(int i = maxIdx; i < length - remain + 1; i++ ){
                if(number.charAt(maxIdx) < number.charAt(i)) maxIdx = i;
            }
            answerArr[answerArr.length - remain] = number.charAt(maxIdx);
            maxIdx ++;
            remain --;
            if(remain == 0) break;
        }

        return new String(answerArr);
    }

}
