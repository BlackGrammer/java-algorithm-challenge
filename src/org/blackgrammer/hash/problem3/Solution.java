package org.blackgrammer.hash.problem3;

import java.util.HashMap;
import java.util.Map;

/**
 * 위장 _ 프로그래머스 _ 해시
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42578">
 */
public class Solution {

    public int solution(String[][] clothes) {

        Map<String, Integer> clotheCountByCategory = new HashMap<>();

        // 옷을 종류별로 분류하여 카운트
        for (String[] clothe : clothes) {
            clotheCountByCategory.put(clothe[1], clotheCountByCategory.getOrDefault(clothe[1], 0) + 1);
        }

        // 안입는 수까지 포함하여 모두 곱하여 총 경우의수 계산
        int answer = 1;
        for(Map.Entry<String,Integer> entry : clotheCountByCategory.entrySet()) {
            answer *= (entry.getValue()+1); // 가지수 + 안입는경우 1
        }

        // 전부 안입는 경우 1가지 제외
        answer--;

        return answer;
    }
}
