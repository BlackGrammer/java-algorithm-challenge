package org.blackgrammer.heap.problem3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 디스크 컨트롤러 _ 프로그래머스 _ 힙
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42627">프로그래머스</a>
 */
public class Solution {

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> controllerQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] + o1[1] <= o2[0]) {
                return -1;
            } else {
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int lastTime = 0;

        for (int[] job : jobs) {
            controllerQueue.offer(job);
        }

        while (!controllerQueue.isEmpty()) {
            int[] nextJob = controllerQueue.poll();
            if (lastTime >= nextJob[0]) {
                lastTime += nextJob[1];
            } else {
                lastTime = nextJob[0] + nextJob[1];
            }
            answer += lastTime - nextJob[0];
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }
}
