import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int work:works){
            pq.add(work);
        }        
        // System.out.println(pq.poll());
                
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()) return 0;
            
            int cur = pq.poll();
            cur -= 1;
            if(cur > 0) pq.add(cur);
        }
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer += cur * cur;
        }
        
        
        return answer;
    }
}