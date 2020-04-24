package org.blackgrammer.fs.problem4;


import java.util.*;

/**
 * 여행경로 _ 프로그래머스 _ 깊이/너비 우선 탐색
 *
 * @author blackgrammer
 * @see <a href="https://programmers.co.kr/learn/courses/30/lessons/43164">프로그래머스</a>
 */
public class Solution {

    public String[] solution(String[][] tickets) {
        PriorityQueue<String> possibleRoute = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0, len = tickets.length; i < len; i++) {
            if (tickets[i][0].equals("ICN")) {
                List<Integer> visit = new LinkedList<>();
                visit.add(i);
                findRoute(tickets, visit, possibleRoute);
            }
        }
        return makeRouteStrToArr(possibleRoute);
    }

    private void findRoute(String[][] tickets, List<Integer> visit, PriorityQueue<String> possibleRoute) {
        if (visit.size() == tickets.length) {
            possibleRoute.offer(makeRouteArrToString(visit, tickets));
            return;
        }

        for (int i = 0, len = tickets.length; i < len; i++) {
            if (!visit.contains(i) && tickets[i][0].equals(getLastRoute(tickets, visit))) {
                List<Integer> copyVisit = new LinkedList<>(visit);
                copyVisit.add(i);
                findRoute(tickets, copyVisit, possibleRoute);
            }
        }
    }

    private String getLastRoute(String[][] tickets, List<Integer> visit) {
        return tickets[visit.get(visit.size() - 1)][1];
    }

    private String makeRouteArrToString(List<Integer> visit, String[][] tickets) {
        StringBuilder routeStr = new StringBuilder();
        routeStr.append(tickets[visit.get(0)][0]);

        for (int i = 0, len = visit.size(); i < len; i++) {
            routeStr.append(tickets[visit.get(i)][1]);
        }
        return routeStr.toString();
    }

    private String[] makeRouteStrToArr(PriorityQueue<String> possibleRoute) {
        String appendedStr = possibleRoute.poll();
        int citySize = appendedStr.length() / 3;
        String[] routeArr = new String[citySize];

        for (int i = 0; i < citySize; i++) {
            routeArr[i] = appendedStr.substring(i * 3, (i + 1) * 3);
        }
        return routeArr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(s.solution(new String[][]{{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}})));
        System.out.println(Arrays.toString(s.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}})));

    }


}
