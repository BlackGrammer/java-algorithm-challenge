package org.blackgrammer.queue.problem4;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 주식가격 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42584">프로그래머스</a>
 * */
public class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> priceQueue = new ArrayDeque<>();
        int priceLength = prices.length;
        int[] answer = new int[priceLength];

        for (int price : prices) {
            priceQueue.add(price);
        }

        int targetIndex = 0;
        while (priceQueue.size() != 0) {
            int prevPrice = priceQueue.poll();
            for (int second = targetIndex; second < priceLength; second++) {
                // 가격 떨어졌을시 answer 에 소요시간 추가
                if (prevPrice > prices[second]) {
                    answer[targetIndex] = second - targetIndex;
                    break;
                }

                // 마지막까지 떨어진것 못찾았을때
                if (second == priceLength - 1) {
                    answer[targetIndex] = second - targetIndex;
                }
            }
            targetIndex++;
        }


        return answer;
    }
}
