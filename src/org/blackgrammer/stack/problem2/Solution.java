package org.blackgrammer.stack.problem2;

import java.util.Stack;

/**
 * 쇠막대기 _ 프로그래머스 _ 스택/큐
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42585">프로그래머스</a>
 */
public class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        String[] strArr = arrangement.split("");
        Stack<Bar> barStack = new Stack<>();
        boolean insertJustBefore = false;
        for (String str : strArr) {
            if (str.equals("(")) {
                barStack.push(new Bar(str, false));
                insertJustBefore = true;
            } else {
                if (insertJustBefore) {
                    answer += barStack.size() - 1;
                    for (Bar bar : barStack) {
                        bar.isCut = true;
                    }
                } else if (barStack.peek().isCut) {
                    answer += 1;
                }
                insertJustBefore = false;
                barStack.pop();
            }
        }
        return answer;
    }

    class Bar {
        String value;
        boolean isCut;

        public Bar(String value, boolean isCut) {
            this.value = value;
            this.isCut = isCut;
        }
    }
}
