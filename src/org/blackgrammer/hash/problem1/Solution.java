package org.blackgrammer.hash.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한선수 _ 프로그래머스 _ 해시
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42576">프로그래머스</a>
 */

public class Solution {

    public String solution(String[] participant, String[] completion) {

        String answer = null;

        // 완주자 맵
        Map<String, Integer> completionMap = new HashMap<>();
        for (String targetCompletion : completion) {
            // 존재한다면 반복수 증가
            if (completionMap.containsKey(targetCompletion)) {
                completionMap.put(targetCompletion, completionMap.get(targetCompletion) + 1);
            }
            // 존재하지 않는다면 반복수 1 으로 추가
            else {
                completionMap.put(targetCompletion, 1);
            }
        }

        // 참가자, 완주자 비교
        for (String targetParticipant : participant) {
            // 완주자 맵에 존재 하지 않는 다면 종료
            if (!completionMap.containsKey(targetParticipant)) {
                answer = targetParticipant;
                break;
            }
            // 완주자 맵에 존재한다면 반복수 감소
            else {
                completionMap.put(targetParticipant, completionMap.get(targetParticipant) - 1);
            }
        }

        // 아직 비완주자 못찾았다면 반복수 체크
        if (answer == null) {
            for (Map.Entry<String, Integer> completionEntry : completionMap.entrySet()) {
                if (completionEntry.getValue() < 0) {
                    answer = completionEntry.getKey();
                    break;
                }
            }
        }

        return answer;
    }

}
