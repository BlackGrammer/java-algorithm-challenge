package org.blackgrammer.graph.problem3;


import java.util.HashSet;
import java.util.Set;

/**
 * 사이클 제거 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49188">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] edges) {

        Set<Integer> possible = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            // i 번 노드일경우 PASS -- edge 없다고 가정
            // 노드들 dfs 로 탐색하면서 사이클 있는지 확인
            // 사이클 존재한다면 set 에 추가
        }

        // 가능한 node 번호들 더하여 답 return
        int answer = 0;
        for(int ans : possible) {
            answer += ans;
        }

        return answer;
    }

}
