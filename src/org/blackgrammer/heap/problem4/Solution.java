package org.blackgrammer.heap.problem4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐 _ 프로그래머스 _ 힙
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42628">프로그래머스</a>
 */
public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> reversedQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (String operation : operations) {
            if (operation.charAt(0) == 'I') {
                Integer targetValue = Integer.valueOf(operation.substring(2));
                pQueue.offer(targetValue);
                reversedQueue.offer(targetValue);
            } else if (operation.charAt(2) == '-') {
                Integer polledValue = reversedQueue.poll();
                pQueue.remove(polledValue);
            } else {
                Integer polledValue = pQueue.poll();
                reversedQueue.remove(polledValue);
            }
        }
        int[] answer = new int[2];
        Integer min = reversedQueue.poll();
        Integer max = pQueue.poll();
        answer[0] = max == null ? 0 : max;
        answer[1] = min == null ? 0 : min;
        return answer;
    }

}
