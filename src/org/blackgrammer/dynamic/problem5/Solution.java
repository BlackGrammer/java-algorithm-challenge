package org.blackgrammer.dynamic.problem5;


/**
 * 카드게임 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42896">프로그래머스</a>
 */
public class Solution {

    public int solution(int[] left, int[] right) {
        int length = left.length;
        int[][] store = new int[length][length];

        return findRoute(left, right, 0, 0, store, 0);
    }

    public int findRoute(int[] left, int[] right, int leftIdx, int rightIdx, int[][] store, int accum) {
        int lNum = left[leftIdx];
        int rNum = right[rightIdx];
        int length = left.length;
        if (lNum > rNum) {
            accum += rNum;
            rightIdx++;
            if (rightIdx == length) return accum;
            if (store[leftIdx][rightIdx] < accum || accum == 0) {
                store[leftIdx][rightIdx] = accum;
                accum = Math.max(accum, findRoute(left, right, leftIdx, rightIdx, store, accum));
            }
        } else {
            leftIdx++;
            int accum1 = 0;
            int accum2 = 0;
            if (leftIdx == length) return accum;
            if (store[leftIdx][rightIdx] < accum || accum == 0) {
                store[leftIdx][rightIdx] = accum;
                accum1 = Math.max(accum, findRoute(left, right, leftIdx, rightIdx, store, accum));
            }
            rightIdx++;
            if (rightIdx == length) return accum;
            if (store[leftIdx][rightIdx] < accum || accum == 0) {
                store[leftIdx][rightIdx] = accum;
                accum2 = Math.max(accum, findRoute(left, right, leftIdx, rightIdx, store, accum));
            }
            accum = Math.max(accum1, accum2);
        }

        return accum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 2, 5}, new int[]{2, 4, 1})); // 7
        System.out.println(s.solution(new int[]{2, 3, 5}, new int[]{2, 4, 1})); // 7
        System.out.println(s.solution(new int[]{2, 3, 5}, new int[]{2, 6, 1})); // 3
        System.out.println(s.solution(new int[]{1, 1, 5, 5, 4}, new int[]{6, 6, 1, 1, 1})); // 3
        System.out.println(s.solution(new int[]{4, 5, 2}, new int[]{1, 5, 1})); // 2
        System.out.println(s.solution(new int[]{4, 5, 2}, new int[]{1, 5, 1})); // 2
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 3}, new int[]{2, 3, 1, 1, 1})); // 3
    }
}
