import java.util.*;

class Solution {
    static int waitTime = Integer.MAX_VALUE;
    static PriorityQueue<Integer>[] mentors;
    public int solution(int k, int n, int[][] reqs) {
        mentors = new PriorityQueue[k];
        for(int i = 0; i < k; i++) {
            mentors[i] = new PriorityQueue<>();
            mentors[i].add(0);
        }
        bt(k, 0, n - k, reqs);
        return waitTime;
    }
    
    public void bt(int k, int curIdx, int leftMentor, int[][] reqs){
        if(leftMentor == 0) {
            checkTime(k, reqs);
            return;
        }
        
        for(int i = curIdx; i < k; i++){
            mentors[i].add(0);
            bt(k, i, leftMentor - 1, reqs);
            mentors[i].poll();    
        }
    }
    
    public void checkTime(int k, int[][] reqs) {
        int totalSpentTime = 0;        
        
        // 결과 큐 오염을 막기 위해 객체 복사
        PriorityQueue<Integer>[] curMentors = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {            
            curMentors[i] = new PriorityQueue<>(mentors[i]);
        }
        
        for(int i = 0; i < reqs.length; i++){
            int start = reqs[i][0];
            int spendTime = reqs[i][1];
            int type = reqs[i][2] - 1;
            
            // 가장 대기가 짧은 멘토
            int shortest = curMentors[type].poll(); 
            
            // 대기가 발생한 경우
            if(shortest > start) {  
                totalSpentTime += shortest - start;
                curMentors[type].add(shortest + spendTime);
            } else {
                curMentors[type].add(start + spendTime);   
            }            
        }
        
        waitTime = Math.min(waitTime, totalSpentTime);
        return;
    }
}