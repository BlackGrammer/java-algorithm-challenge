package org.blackgrammer.queue.problem2;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * 프린터 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42587">
 */

public class Solution {

    public static final String IS_TARGET = "target";
    public static final String DOC_PRIORITY = "priority";
    public static final Integer TRUE = 1;
    public static final Integer FALSE = 0;

    public int solution(int[] priorities, int location) {

        LinkedList<HashMap<String, Integer>> docList = new LinkedList<>(); // 문서리스트 (위치, 중요도)

        int prevLocation = 0;
        for (int priority : priorities) {
            HashMap<String, Integer> doc = new HashMap<>();
            doc.put(IS_TARGET, prevLocation == location ? TRUE : FALSE);
            doc.put(DOC_PRIORITY, priority);
            docList.add(doc);
            prevLocation++;
        }

        int answer = 0;
        while (true) {

            boolean isExistBigger = false;
            HashMap<String, Integer> targetDoc = docList.get(0);

            for (HashMap<String, Integer> doc : docList) {
                if (doc.get(DOC_PRIORITY) > targetDoc.get(DOC_PRIORITY)) {
                    isExistBigger = true;
                    break;
                }
            }

            if (isExistBigger) {
                docList.add(docList.size(), targetDoc);
            } else {
                answer++;
                if (targetDoc.get(IS_TARGET).equals(TRUE)) break;
            }
            docList.remove(0);
        }

        return answer;
    }


}
