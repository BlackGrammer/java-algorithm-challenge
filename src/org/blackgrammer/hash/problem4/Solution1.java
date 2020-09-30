package org.blackgrammer.hash.problem4;

import java.util.*;


public class Solution1 implements Solution {

    public int[] solution(String[] genres, int[] plays) {

        // 장르별 카운트
        HashMap<String, Integer> countsByGenre = new HashMap<>();

        // 장르별 곡 목록
        HashMap<String, ArrayList<Integer>> allSongIdsByGenre = new HashMap<>();

        for (int targetSongId = 0; targetSongId < genres.length; targetSongId++) {
            String targetGenre = genres[targetSongId];
            int targetPlayCount = plays[targetSongId];

            ArrayList<Integer> prevSelectedSongIds = allSongIdsByGenre.getOrDefault(targetGenre, new ArrayList<>());
            if (prevSelectedSongIds.size() == 0) allSongIdsByGenre.put(targetGenre, prevSelectedSongIds);

            // 아직 해당장르에 선별된 곡이 없다면
            if (prevSelectedSongIds.size() == 0) {
                prevSelectedSongIds.add(targetSongId); // 곡 추가
            }
            // 선별된 곡이 존재할 때
            else {
                int songIdLength = prevSelectedSongIds.size();

                for (int prevIdsIndex = 0; prevIdsIndex < songIdLength; prevIdsIndex++) {

                    // 기존에 저장된 곡 보다 플레이수가 많다면
                    if (targetPlayCount > plays[prevSelectedSongIds.get(prevIdsIndex)]) {
                        // 곡 목록 변경
                        prevSelectedSongIds.add(prevIdsIndex, targetSongId);
                        // 곡 목록 길이 3이상 이면 마지막 제거
                        if (prevSelectedSongIds.size() == 3) prevSelectedSongIds.remove(2);
                        break;
                    }

                    // 플레이 수가 많은 것은 아니지만 두번째로 들어온 곡일때
                    else if (prevSelectedSongIds.size() == 1) {
                        prevSelectedSongIds.add(1, targetSongId);
                        break;
                    }
                }
            }

            countsByGenre.put(targetGenre, countsByGenre.getOrDefault(targetGenre, 0) + targetPlayCount); // 장르별 카운트에 추가
        }

        // 장르별 카운트 정렬
        ArrayList<String> genresOrdered = new ArrayList<>(countsByGenre.keySet());
        genresOrdered.sort((s, t1) -> countsByGenre.get(t1) - countsByGenre.get(s));

        LinkedList<Integer> answerList = new LinkedList<>();

        // 장르별로 곡 꺼내어 담기
        for (String genre : genresOrdered) {
            answerList.addAll(allSongIdsByGenre.get(genre));
        }

        // int 형 배열 생성
        int[] answerArray = new int[answerList.size()];

        // int 형 배열에 옮겨담기
        int orderedListIndex = 0;
        for (Integer orderedSongId : answerList) {
            answerArray[orderedListIndex] = orderedSongId;
            orderedListIndex++;
        }

        return answerArray;
    }

}
