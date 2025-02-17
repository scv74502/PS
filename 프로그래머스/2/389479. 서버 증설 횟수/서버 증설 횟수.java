import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
        
        for(int i = 0; i < players.length; i++){
            // peek을 통해 i+k시까지 동작하는 서버들은 제거
            while(!pq.isEmpty() && pq.peek() == i){
                pq.poll();
            }
            
            // i시부터 i+1시까지 사용자 수 구함
            int playerAmount = players[i];
            int minServer = playerAmount / m;   // 이융자 수 / m 하면 필요한 서버수 n이 나옴                        
            
            // 필요 시 서버 증설하며 i + k시까지 사용기한 설정
            while(minServer > pq.size()){
                // System.out.println("i : " + i + ", playerAmount : " + playerAmount + ", minServer : " + minServer + ", serverAmount : " + pq.size());
                pq.add(i + k);
                answer++;
            }
             // System.out.println("i : " + i + ", serverAmount : " + pq.size());
        }
        return answer;
    }
}