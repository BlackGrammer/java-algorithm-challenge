package org.blackgrammer.queue.problem1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  기능개발 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42586">
 */

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        int jobCount = progresses.length; // 작업수
        int[] remainDays = new int[jobCount]; // 완료시까지 걸리는 날짜 배열

        // 완료시까지 걸리는 날짜 계산
        for (int jobPriority = 0; jobPriority < jobCount; jobPriority++) {
            int remainDay = (int) Math.ceil( (100-progresses[jobPriority]) / (double) speeds[jobPriority]);
            remainDays[jobPriority] = remainDay;
        }


        int outCount = 0; // 꺼낼 작업수
        int remainDayOfHead = 0; // 맨앞의 남은 날짜
        LinkedList<Integer> outCountList = new LinkedList<>();
        for (int remainDay : remainDays) {
            if (remainDay <= remainDayOfHead) {
                // 꺼낼 작업수 증가
                outCount++;
            } else {
                // 쌓여있던 꺼낼 작업수 List 에 담기
                if(outCount != 0) outCountList.add(outCount);
                // 꺼낼 작업수 초기화 및 맨앞의 남은 날짜 현재 값으로 변경
                outCount = 1;
                remainDayOfHead = remainDay;
            }
        }
        // 마지막에 쌓여있던 값 List에 담기
        outCountList.add(outCount);

        return outCountList.stream().mapToInt(i -> i).toArray();
    }

    // 프로그래머스에 올라온 다른 답변
    public int[] anotherSolution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        // 큐의 머리부터 완료된 날짜를 증가시켜가면서 한번에 끝나는 작업수 계산
        // while 문에서 상수연산이 너무 많이 발생할수도 있지 않을까????
        // 프로그래머스에서 돌려볼때 작업수행 시간측면에서 케이스별로 간혹 매우 오래걸리는 경우가 있다
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }


}
