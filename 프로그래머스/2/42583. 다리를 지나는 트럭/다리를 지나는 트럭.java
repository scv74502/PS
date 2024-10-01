import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;                
        int weightSum = 0;
        int idx = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        while(bridge.size() < bridge_length){
            bridge.add(0);
        }
        
        while(idx < truck_weights.length){
            answer++;
            //System.out.println("weightSum : " + weightSum);
            //System.out.println("bridge : " + bridge);
            
            if(bridge.size() == bridge_length){
                //System.out.println("bridge after size : " + bridge.size());
                weightSum -= bridge.poll();
            }
            
            if(weightSum + truck_weights[idx] <= weight){
                bridge.add(truck_weights[idx]);
                //System.out.println("bridge after : " + bridge);
                weightSum = weightSum + truck_weights[idx];
                idx++;
            } else{
                bridge.add(0);
                //System.out.println("bridge after : " + bridge);
            }                                    
        }
        
        while(weightSum > 0){
            //System.out.println("remain poll : " + bridge);
            weightSum -= bridge.poll();
            answer++;            
        }
        
        //System.out.println(answer);
        
        return answer;
    }
}