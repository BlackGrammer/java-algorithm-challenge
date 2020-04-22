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
        PriorityQueue<String> possibleRoute = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length();
//                for(int i = 1,)
                return 1;
            }
        });


        for (int i = 0, len = tickets.length; i < len; i++) {
            if(tickets[i][0].equals("ICN")) {
                List<Integer> visit = new ArrayList<>();
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
                visit.add(i);
                findRoute(tickets, visit, possibleRoute);
            }
        }
    }

    private String getLastRoute(String[][] tickets, List<Integer> visit) {
        return tickets[visit.get(visit.size() - 1)][1];
    }

    private String makeRouteArrToString(List<Integer> visit, String[][] tickets) {
        StringBuilder routeStr = new StringBuilder();
        routeStr.append(tickets[0][0]);

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
    }


}
