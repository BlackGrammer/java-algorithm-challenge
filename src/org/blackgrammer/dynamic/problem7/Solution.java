package org.blackgrammer.dynamic.problem7;


import java.util.*;

/**
 * 서울에서 경산까지 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42899">프로그래머스</a>
 */
public class Solution {
    public int solution(int K, int[][] travel) {
        Arrays.sort(travel, Comparator.comparingInt(o -> (o[1] - o[3])));
        Stack<int[]> bikeStack = new Stack<>();
        int timeSum = 0;
        int costSum = 0;
        for (int[] t : travel) {
            timeSum += t[0];
            costSum += t[1];
        }

        for (int[] t : travel) {
            int timeSave = t[0] - t[2];
            int costDecrease = t[1] - t[3];
            if (timeSum > K) {
                bikeStack.push(new int[]{timeSave, costDecrease});
                timeSum -= timeSave;
                costSum -= costDecrease;
            } else {
                int prevDiffSum = 0;
                int prevCostSum = 0;
                Stack<int[]> tmpQueue = new Stack<>();
                while (timeSum - prevDiffSum + timeSave <= K) {
                    int[] target = bikeStack.pop();
                    prevDiffSum += target[0];
                    prevCostSum += target[1];
                    tmpQueue.push(target);
                }
                if (prevCostSum > costDecrease) {
                    timeSum += prevDiffSum - timeSave;
                    costSum += prevCostSum - costDecrease;
                    bikeStack.push(new int[]{timeSave, costDecrease});
                } else {
                    while (!tmpQueue.isEmpty()) {
                        bikeStack.push(tmpQueue.pop());
                    }
                }
            }
        }

        return costSum;
    }


}
