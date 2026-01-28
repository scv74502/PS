import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playtimeByGenre = new HashMap<>();
        HashMap<String, List<SongInfo>> songByGenre = new HashMap<>();
        ArrayList<SongInfo> songlist = new ArrayList<>();
        
        for(int i = 0; i < plays.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            if(!playtimeByGenre.containsKey(genre)){
                playtimeByGenre.put(genre, play);
            } else {
                playtimeByGenre.put(genre, playtimeByGenre.get(genre) + play);
            }
        
            if(!songByGenre.containsKey(genre)){
                songByGenre.put(genre, new ArrayList<>());
                songByGenre.get(genre).add(new SongInfo(i, play));
            } else{
                songByGenre.get(genre).add(new SongInfo(i, play));
            }
                        
        }

        // 장르 이름들만 뽑아서 리스트로
        List<String> genreList = new ArrayList<>(playtimeByGenre.keySet());

        // 재생시간 내림차순 정렬(큰게 앞으로)
        Collections.sort(genreList, (o1, o2) -> 
            playtimeByGenre.get(o2) - playtimeByGenre.get(o1)
        );
        
        ArrayList<Integer> resultList = new ArrayList<>();

        for(String genre : genreList){ // 정렬된 장르 리스트를 순회
            List<SongInfo> songs = songByGenre.get(genre);
            Collections.sort(songs); // 노래 정렬 (재생수 내림차순, 번호 오름차순)

            // 최대 2개까지만 리스트에 담기
            resultList.add(songs.get(0).no);
            if(songs.size() > 1){
                resultList.add(songs.get(1).no);
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}

class SongInfo implements Comparable<SongInfo> {    
    int no;
    int playtime;
    
    public SongInfo(int no, int playtime){        
        this.no = no;
        this.playtime = playtime;
    }
    
    @Override
    public int compareTo(SongInfo si){
        if(si.playtime == this.playtime){
            return this.no - si.no;
        }
        return si.playtime - this.playtime;
    }    
}