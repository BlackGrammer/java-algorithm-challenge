package org.blackgrammer.fs.problem2;

import java.util.HashMap;
import java.util.Map;

/**
 * 네트워크 _ 프로그래머스 _ 깊이/너비 우선 탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43162">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] computers) {

        Map<Integer, Object> group = new HashMap<>();
        Map<Integer, Object> visit = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (visit.get(i) == null) findNetworkGroup(group, visit, computers, i, i);
        }

        return group.size();
    }


    private void findNetworkGroup(Map<Integer, Object> group, Map<Integer, Object> visit, int[][] computers, int start, int target) {

        visit.put(target, true);
        boolean flag = false;

        // 연결된 노드 검색 loop
        for (int i = 0; i < computers.length; i++) {
            // 연결되있고 방문한 곳이 아니라면 재귀 호출, start 유지, target 해당 노드로 변경
            if (computers[target][i] == 1 && target != i) {
                flag = true;
                if (visit.get(i) == null) {
                    group.putIfAbsent(start, true);
                    findNetworkGroup(group, visit, computers, start, i);
                }
            }
        }

        if (!flag) group.putIfAbsent(target, true);
    }

}
