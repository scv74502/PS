import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int N = plays.length;
        
        HashMap<String, Integer> playPerGenre = new HashMap<>();
        HashMap<String, ArrayList<SongInfo>> songPerGenre = new HashMap<>();
        
        // 장르별 재생시간, 장르별 곡 목록 정리하기
        for(int i = 0; i < plays.length; i++){
            if(!playPerGenre.containsKey(genres[i])){
                playPerGenre.put(genres[i], plays[i]);
            } else{
                playPerGenre.put(genres[i], playPerGenre.get(genres[i]) + plays[i]);
            }
            
            if(!songPerGenre.containsKey(genres[i])){
                songPerGenre.put(genres[i], new ArrayList<>());
            }
            
            songPerGenre.get(genres[i]).add(new SongInfo(i, plays[i]));
        }
        
        ArrayList<String> genreList = new ArrayList<>(playPerGenre.keySet());
        Collections.sort(genreList, (o1, o2) -> playPerGenre.get(o2) - playPerGenre.get(o1));
        
        ArrayList<Integer> resultList = new ArrayList<>();

        for(String genre:genreList){
            ArrayList<SongInfo> songs = songPerGenre.get(genre);
            Collections.sort(songs);
            resultList.add(songs.get(0).no);
            
            if(songs.size() > 1) resultList.add(songs.get(1).no);
        }               
        
        int[] answer = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}

class SongInfo implements Comparable<SongInfo> {
    int no;
    int play;
    
    public SongInfo(int no, int play){
        this.no = no;
        this.play = play;
    }
    
    @Override
    public int compareTo(SongInfo songInfo){
        if(this.play == songInfo.play){
            return this.no - songInfo.no; // 고유변호 오름차순(작은 것 먼저)
        }
        return songInfo.play - this.play;   // 재생 내림차순(큰 것 먼저)
    }
}