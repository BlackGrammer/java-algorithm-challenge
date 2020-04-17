package org.blackgrammer.bruteforce.problem4;

/**
 * 카펫 _ 프로그래머스 _ 완전탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42842">프로그래머스</a>
 */
public class Solution {

    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        for (int height = 1, max = (int) Math.ceil(Math.sqrt(brown + red)); height <= max; height++) {
            int totalArea = brown + red;
            if (totalArea % height != 0) continue;
            int width = (totalArea / height);
            if ((width - 2) * (height - 2) == red) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}
