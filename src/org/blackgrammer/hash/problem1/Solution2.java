package org.blackgrammer.hash.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution2 implements Solution {

    @Override
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completionMap = new HashMap<>();
        for (String completionOne : completion) {
            Integer prevCount = completionMap.get(completionOne);
            if (prevCount == null) {
                prevCount = 0;
            }
            completionMap.put(completionOne, prevCount + 1);
        }

        String answer = null;
        for (String participantOne : participant) {
            Integer prevCount = completionMap.get(participantOne);
            if (prevCount == null) {
                answer = participantOne;
                break;
            }
            if (prevCount == 1) {
                completionMap.remove(participantOne);
                continue;
            }
            completionMap.put(participantOne, prevCount - 1);
        }

        return answer;
    }
}
