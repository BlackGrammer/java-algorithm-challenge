package org.blackgrammer.queue.problem3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 다리를 지나는 트럭 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42583">프로그래머스</a>
 */
public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> onBridge = new LinkedList<>();
        for (int idx = 0; idx < bridge_length; idx++) {
            onBridge.add(0);
        }
        int totalTruckCount = truck_weights.length;
        int onWaitingTruckCount = totalTruckCount;
        int onBridgeWeight = 0;

        while ((onWaitingTruckCount > 0) || (onBridge.size() > 0)) {
            int justCrossWeight = onBridge.poll();
            onBridgeWeight -= justCrossWeight;
            int nextTargetTruckIdx = totalTruckCount - onWaitingTruckCount;
            int nextTargetTruckWeight = nextTargetTruckIdx < totalTruckCount ? truck_weights[nextTargetTruckIdx] : 0;

            // 현재 다리에 올라온 트럭무게 + 다음트럭무게 <= 다리가 견디는 하중 --> 새로운 트럭 올려보내기
            if( (onBridgeWeight + nextTargetTruckWeight <= weight ) && ( nextTargetTruckWeight > 0) ) {
                onBridgeWeight += nextTargetTruckWeight;
                onBridge.add(nextTargetTruckWeight);
                onWaitingTruckCount--;
            }
            // 새로운 트럭 못올려보냄 + 남은트럭 있음
            else if (nextTargetTruckWeight > 0){
                onBridge.add(0);
            }
            answer++;
        }

        return answer;
    }
}
