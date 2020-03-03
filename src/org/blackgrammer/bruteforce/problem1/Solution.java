package org.blackgrammer.bruteforce.problem1;

import java.util.*;

/**
 * 모의고사 _ 프로그래머스 _ 완전탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/42840">프로그래머스</a>
 */

public class Solution {
    public int[] solution(int[] answers) {

        Candidate c1 = new Candidate1();
        Candidate c2 = new Candidate2();
        Candidate c3 = new Candidate3();

        int[] score1 = new int[]{1, 0};
        int[] score2 = new int[]{2, 0};
        int[] score3 = new int[]{3, 0};

        int[][] scoreSheet = new int[][]{score1, score2, score3};

        for (int index = 0, length = answers.length; index < length; index++) {
            if (c1.isCorrect(index, answers[index])) score1[1] += 1;
            if (c2.isCorrect(index, answers[index])) score2[1] += 1;
            if (c3.isCorrect(index, answers[index])) score3[1] += 1;
        }

        List<Integer> rank = new ArrayList<>();
        int maxScore = 0;

        for (int[] score : scoreSheet) {
            int targetScore = score[1];
            if (maxScore <= targetScore) {
                if (maxScore != targetScore) rank.clear();
                rank.add(score[0]);
                maxScore = targetScore;
            }
        }

        rank.sort(Comparator.comparingInt(o -> o));
        Integer[] tmpAnswer = rank.toArray(new Integer[0]);
        int[] answer = new int[tmpAnswer.length];
        for (int index = 0, length = tmpAnswer.length; index < length; index++) {
            answer[index] = tmpAnswer[index];
        }

        return answer;
    }


    abstract class Candidate {
        abstract int getPickedNumber(int index);

        public boolean isCorrect(int index, int answer) {
            return getPickedNumber(index) == answer;
        }
    }

    class Candidate1 extends Candidate {

        @Override
        int getPickedNumber(int index) {
            return index % 5 + 1;
        }
    }

    class Candidate2 extends Candidate {

        @Override
        int getPickedNumber(int index) {
            if (index % 2 == 0) return 2;
            int caseNum = index / 2 % 4;
            if (caseNum == 0) return 1;
            return caseNum + 2;
        }
    }

    class Candidate3 extends Candidate {

        private int[] pickOrdered;

        public Candidate3() {
            this.pickOrdered = new int[]{3, 1, 2, 4, 5};
        }

        @Override
        int getPickedNumber(int index) {
            return this.pickOrdered[index / 2 % 5];
        }
    }

}
