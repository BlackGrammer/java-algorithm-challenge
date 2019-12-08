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
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> controllerQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int answer = 0;
        int lastTime = 0;
        int jobIdx = 0;

        while (jobIdx < jobs.length) {
            int[] targetJob = jobs[jobIdx];
            if (targetJob[0] <= lastTime) {
                controllerQueue.offer(targetJob);
                jobIdx++;
                continue;
            }

            if (controllerQueue.isEmpty()) {
                int[] nextJob = jobs[jobIdx];
                lastTime = nextJob[0] + nextJob[1];
                answer += nextJob[1];
                jobIdx++;
            } else {
                int[] priorityJob = controllerQueue.poll();
                lastTime += priorityJob[1];
                answer += lastTime - priorityJob[0];

                if (jobIdx == jobs.length - 1) {
                    controllerQueue.offer(jobs[jobIdx]);
                    jobIdx++;
                }
            }
        }

        while (!controllerQueue.isEmpty()) {
            int[] priorityJob = controllerQueue.poll();
            if (lastTime < priorityJob[0]) {
                lastTime = priorityJob[0] + priorityJob[1];
            } else {
                lastTime += priorityJob[1];
            }
            answer += lastTime - priorityJob[0];
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{1, 9}, {0, 3}, {2, 6}}));
    }
}
