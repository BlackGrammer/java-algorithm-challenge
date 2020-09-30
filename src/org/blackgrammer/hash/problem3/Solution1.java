package org.blackgrammer.hash.problem3;

import java.util.HashMap;
import java.util.Map;

public class Solution1 implements Solution {

    @Override
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (Map.Entry<String, Integer> mapElement : clothesMap.entrySet()) {
            answer *= mapElement.getValue() + 1;
        }
        return --answer;
    }
}
