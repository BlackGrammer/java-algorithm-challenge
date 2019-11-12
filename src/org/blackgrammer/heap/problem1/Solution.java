package org.blackgrammer.heap.problem1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 더 맵게 _ 프로그래머스 _ 힙
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42626">프로그래머스</a>
 */
public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int targetScoville : scoville) {
            scovilleQueue.offer(targetScoville);
        }

        while (scovilleQueue.peek() < K) {
            // 더이상 스코빌 지수를 늘릴 수 없을때는 -1 리턴
            if (scovilleQueue.size() == 1) return -1;
            answer++;
            int firstMinScov = scovilleQueue.poll();
            int secondMinScov = scovilleQueue.poll();
            int mixedScov = firstMinScov + (secondMinScov * 2);
            scovilleQueue.offer(mixedScov);
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
