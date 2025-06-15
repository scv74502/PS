import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add(new int[] {progresses[i], i});
        }
        
        ArrayList<Integer> deployedPerDay = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int rpt = queue.size();                       
            for(int i = 0; i < rpt; i++){
                int[] curProgress = queue.poll();
                curProgress[0] += speeds[curProgress[1]];                                                
                queue.add(curProgress);
            }
            
            int deployed = 0;
            
            while(!queue.isEmpty() && queue.peek()[0] >= 100) {
                queue.poll();
                deployed++;
            }
            if(deployed > 0) deployedPerDay.add(deployed);
        }                        
        
        
        // System.out.println(deployedPerDay);
        
        int[] answer = new int[deployedPerDay.size()];
        
        for(int i = 0; i < deployedPerDay.size(); i++){
            answer[i] = deployedPerDay.get(i);
        }
        
        return answer;
    }
}