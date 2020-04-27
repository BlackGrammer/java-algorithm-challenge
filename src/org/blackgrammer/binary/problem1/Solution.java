package org.blackgrammer.binary.problem1;

/**
 * 예산 _ 프로그래머스 _ 이분탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43237">프로그래머스</a>
 */
public class Solution {
    public int solution(int[] budgets, int M) {
        int max = 0;
        int target = M;

        int maxBudget = 0;
        for (int budget : budgets) {
            maxBudget = Math.max(maxBudget, budget);
        }

        while (true) {
            long sumOfBudgets = 0;
            for (int budget : budgets) {
                int possibleBudget = Math.min(budget, target);
                sumOfBudgets += possibleBudget;
            }
            if (sumOfBudgets <= M) {
                int prevMax = max;
                max = Math.max(max, target);
                if (Math.abs(prevMax - target) < 2) {
                    max = Math.min(maxBudget, max);
                    break;
                }
                target = prevMax < target ? (M + target) / 2 : (prevMax + target) / 2;
                continue;
            }
            target = (target + max) / 2;
        }
        return max;
    }
}
