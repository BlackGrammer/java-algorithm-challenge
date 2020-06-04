package org.blackgrammer.dynamic.problem2;


/**
 * 타일 장식물 _ 프로그래머스 _ 동적계획법
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43104">프로그래머스</a>
 */
public class Solution {

    public long solution(int N) {
        long[] store = new long[N];
        store[0] = 1;
        store[1] = 1;

        for (int i = 2; i < N; i++) {
            store[i] = store[i - 1] + store[i - 2];
        }
        return store[N - 1] * 4 + store[N - 2] * 2;
    }

}
