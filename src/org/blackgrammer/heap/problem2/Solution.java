package org.blackgrammer.heap.problem2;

import java.util.PriorityQueue;

/**
 * 라면공장 _ 프로그래머스 _ 힙
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42629">프로그래머스</a>
 */
public class Solution {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> supplyQueue = new PriorityQueue<>((v1,v2) -> (v2-v1));

        int lastSuppliedDate = 0;
        for (int i = 0, length = dates.length; i < length; i++) {
            supplyQueue.offer(supplies[i]);
            int currentDate = dates[i];
            stock -= (currentDate - lastSuppliedDate);
            int nextDate = i == (length - 1) ? k : dates[i + 1];
            int expectedStock = stock - (nextDate - currentDate);

            while (expectedStock < 0) {
                int suppliedStock = supplyQueue.poll();
                expectedStock += suppliedStock;
                stock += suppliedStock;
                answer++;
            }
            lastSuppliedDate = currentDate;
        }
        return answer;
    }

}
