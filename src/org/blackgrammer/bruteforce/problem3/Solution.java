package org.blackgrammer.bruteforce.problem3;

/**
 * 숫자야구 _ 프로그래머스 _ 완전탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42841">프로그래머스</a>
 */
public class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        StringBuilder expectedAnswer = new StringBuilder();

        for (int i1 = 1; i1 < 10; i1++) {
            expectedAnswer.append(i1);

            for (int i2 = 1; i2 < 10; i2++) {
                if (i2 == i1) continue;
                expectedAnswer.append(i2);

                for (int i3 = 1; i3 < 10; i3++) {
                    if (i3 == i1 || i3 == i2) continue;
                    expectedAnswer.append(i3);
                    if (isPossibleCase(expectedAnswer.toString(), baseball)) answer++;
                    expectedAnswer.delete(2, 3);
                }

                expectedAnswer.delete(1, 2);
            }

            expectedAnswer = new StringBuilder();
        }

        return answer;
    }

    private boolean isPossibleCase(String answer, int[][] baseball) {
        int strike = 0;
        int ball = 0;

        for (int[] baseballCase : baseball) {

            for (int i = 0; i < 3; i++) {
                int pos = String.valueOf(baseballCase[0]).indexOf(answer.charAt(i));
                if (pos == -1) continue;
                if (pos == i) strike++;
                else ball++;
            }

            if (strike != baseballCase[1] || ball != baseballCase[2]) return false;
            strike = 0;
            ball = 0;
        }
        return true;
    }

}
