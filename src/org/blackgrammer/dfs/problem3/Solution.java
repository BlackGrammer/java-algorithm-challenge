package org.blackgrammer.dfs.problem3;

import java.util.*;

/**
 * 단어변환 _ 프로그래머스 _ 깊이/너비 우선 탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43163">프로그래머스</a>
 */
public class Solution {

    /*
        #### 제한사항
        * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
        * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
        * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
        * begin과 target은 같지 않습니다.
        * 변환할 수 없는 경우에는 0를 return 합니다.

        #### 입출력 예
        begin   | target        | words                                         | return
        ---     | ---           | ---                                           | ---
        hit     |	"cog"       |	["hot", "dot", "dog", "lot", "log", "cog"]  |	4
        hit     |	"cog"       |	["hot", "dot", "dog", "lot", "log"]	        |   0
     */

    public int solution(String begin, String target, String[] words) {


        int minCaseCnt = 0;
        Set<Integer> caseCntSet = new HashSet<>();

        for (int i = 0, len = words.length; i < len; i++) {
            boolean[] visits = new boolean[words.length];
            if (getDiffCnt(begin, words[i]) == 1) {
                visits[i] = true;
                getCaseCnt(words[i], words, target, visits, caseCntSet);
            }
        }
        return minCaseCnt;
    }

    private void getCaseCnt(String word, String[] words, String target, boolean[] visits, Set<Integer> caseCntSet) {
        for (int i = 0, len = visits.length; i < len; i++) {
//            if (visits[i])
        }
    }


    private int getDiffCnt(String target, String word) {
        int diffCnt = 0;
        for (int i = 0, len = word.length(); i < len; i++) {
            if (target.charAt(i) != word.charAt(i)) diffCnt++;
        }
        return diffCnt;
    }

}
