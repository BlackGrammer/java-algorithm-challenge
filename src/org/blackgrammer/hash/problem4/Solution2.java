package org.blackgrammer.hash.problem4;

import java.util.*;

public class Solution2 implements Solution {

    @Override
    public int[] solution(String[] genres, int[] plays) {
        int numberOfSongs = genres.length;
        Map<String, Long> playCountMap = new HashMap<>();
        Map<String, PriorityQueue<Song>> songByGenreMap = new HashMap<>();

        for (int idx = 0; idx < numberOfSongs; idx++) {
            playCountMap.put(genres[idx], playCountMap.getOrDefault(genres[idx], 0L) + plays[idx]);
            PriorityQueue<Song> songQueue = songByGenreMap.getOrDefault(genres[idx], new PriorityQueue<>((o1, o2) -> {
                if (o1.getPlayCount() != o2.getPlayCount())
                    return o2.getPlayCount() - o1.getPlayCount();
                else
                    return o1.getId() - o2.getId();
            }));
            songQueue.add(new Song(idx, plays[idx]));
            if (!songByGenreMap.containsKey(genres[idx])) {
                songByGenreMap.put(genres[idx], songQueue);
            }
        }

        List<Map.Entry<String, Long>> playCountList = new LinkedList<>(playCountMap.entrySet());
        playCountList.sort((o1, o2) -> (int)(o2.getValue() - o1.getValue()));

        List<Integer> answerList = new LinkedList<>();
        for (Map.Entry<String, Long> playCount : playCountList) {
            PriorityQueue<Song> songs = songByGenreMap.get(playCount.getKey());
            int songCnt = 0;
            while (!songs.isEmpty() && songCnt < 2) {
                answerList.add(songs.poll().getId());
                songCnt++;
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    class Song {
        private int id;
        private int playCount;

        public Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        public int getId() {
            return id;
        }

        public int getPlayCount() {
            return playCount;
        }
    }
}
