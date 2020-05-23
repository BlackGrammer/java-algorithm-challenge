package org.blackgrammer.greedy.problem3;


/**
 * 조이스틱 _ 프로그래머스 _ 탐욕법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42860">프로그래머스</a>
 */
public class Solution {

    public int solution(String name) {

        char[] charArr = name.toCharArray();
        int maxDiff = 'Z' - 'A' + 1;
        int maxDistance = charArr.length;

        boolean[] visit = new boolean[maxDistance];
        int answer = 0;
        int curr = 0;
        int visitCnt = 0;

        while (visitCnt < maxDistance) {
            for (int i = 0; i < maxDistance / 2 + 1; i++) {
                int fwIdx = curr + i > maxDistance - 1 ? curr + i - maxDistance : curr + i;
                int bwIdx = curr - i < 0 ? curr - i + maxDistance : curr - i;
                char targetFw = charArr[fwIdx];
                char targetBw = charArr[bwIdx];

                boolean isFwFirst = !visit[fwIdx];
                if (targetFw == 'A' && isFwFirst) {
                    visit[fwIdx] = true;
                    visitCnt++;
                }

                boolean isBwFirst = !visit[bwIdx];
                if (targetBw == 'A' && isBwFirst) {
                    visit[bwIdx] = true;
                    visitCnt++;
                }


                if (targetFw != 'A' && isFwFirst) {
                    curr = fwIdx;
                    visit[fwIdx] = true;
                    visitCnt++;
                    answer += i;
                    int diff = targetFw - 'A';
                    answer += Math.min(diff, maxDiff - diff);
                    break;
                }

                if (targetBw != 'A' && isBwFirst) {
                    curr = bwIdx;
                    visit[bwIdx] = true;
                    visitCnt++;
                    answer += i;
                    int diff = targetBw - 'A';
                    answer += Math.min(diff, maxDiff - diff);
                    break;
                }

            }
        }

        return answer;
    }

}
