package org.blackgrammer.dfs.problem3;

import java.util.*;

/**
 * 단어변환 _ 프로그래머스 _ 깊이/너비 우선 탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43163">프로그래머스</a>
 */
public class Solution {

    public int solution(String begin, String target, String[] words) {
        Set<Integer> caseCntSet = new HashSet<>();

        for (int i = 0, len = words.length; i < len; i++) {
            boolean[] visits = new boolean[len];
            if (getDiffCnt(begin, words[i]) == 1) {
                getCaseCnt(i, words, target, visits, caseCntSet);
            }
        }
        return getMinValue(caseCntSet);
    }

    private void getCaseCnt(int index, String[] words, String target, boolean[] visits, Set<Integer> caseCntSet) {
        visits[index] = true;

        if (words[index].equals(target)) {
            caseCntSet.add(getVisitCnt(visits));
            return;
        }

        for (int i = 0, len = words.length; i < len; i++) {
            if (getDiffCnt(words[index], words[i]) == 1 && !visits[i]) {
                boolean[] visitsCopy = new boolean[len];
                System.arraycopy(visits, 0, visitsCopy, 0, len);
                getCaseCnt(i, words, target, visitsCopy, caseCntSet);
            }
        }
    }

    private int getDiffCnt(String target, String word) {
        int diffCnt = 0;
        for (int i = 0, len = word.length(); i < len; i++) {
            if (target.charAt(i) != word.charAt(i)) diffCnt++;
        }
        return diffCnt;
    }

    private int getVisitCnt(boolean[] visits) {
        int cnt = 0;
        for (boolean visit : visits) {
            if (visit) cnt++;
        }
        return cnt;
    }

    private int getMinValue(Set<Integer> cntSet) {
        int minValue = 0;
        for (int val : cntSet) {
            if (val < minValue || minValue == 0) minValue = val;
        }
        return minValue;
    }

}
