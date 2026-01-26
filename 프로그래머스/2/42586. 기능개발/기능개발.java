import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> deployedPerDay = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add(new int[] {progresses[i], i});
        }
        
        int curDeployIdx = 0;
        
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int deployed = 0;

            for(int i = 0; i < queueSize; i++){
                int[] curInfo = queue.poll();
                curInfo[0] += speeds[curInfo[1]];
                
                if (curInfo[0] >= 100 && curDeployIdx == curInfo[1]){
                    curDeployIdx++;
                    deployed++;
                } else {
                    queue.add(curInfo);
                }
            }
            if(deployed > 0) deployedPerDay.add(deployed);
        }
            
        int[] answer = new int[deployedPerDay.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = deployedPerDay.get(i);
        }
        
        return answer;
    }
}