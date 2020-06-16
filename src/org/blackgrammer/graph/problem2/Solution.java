package org.blackgrammer.graph.problem2;


/**
 * 순위 _ 프로그래머스 _ 그래프
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/49191">프로그래머스</a>
 */
public class Solution {

    public int solution(int n, int[][] results) {
        boolean[][] edges = new boolean[n + 1][n + 1];
        int[] cntArr = new int[n + 1];
        int cnt = 0;

        for (int[] result : results) {
            edges[result[0]][result[1]] = true;
            if (++cntArr[result[0]] == n - 1) cnt++;
            if (++cntArr[result[1]] == n - 1) cnt++;
        }

        for (int target = 1; target <= n; target++) {
            for (int winner = 1; winner <= n; winner++) {
                for (int loser = 1; loser <= n; loser++) {
                    if (edges[winner][target] && edges[target][loser] && !edges[winner][loser]) {
                        edges[winner][loser] = true;
                        if (++cntArr[winner] == n - 1) cnt++;
                        if (++cntArr[loser] == n - 1) cnt++;
                    }
                }
            }
        }

        return cnt;
    }


}
