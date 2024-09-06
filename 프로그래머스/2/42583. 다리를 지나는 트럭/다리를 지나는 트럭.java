import java.util.*;
    
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 정답 시간
        int answer = 0;
        
        // 큐를 생성하고 다리 길이만큼 0을 삽입함
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }
        
        // 다리길이가 N이면 N+1 만큼 시간이 걸림에 유의하기
        // 다리 길이가 1이면 트럭의 대수 + 1만큼 시간이 걸린다
        if(bridge_length == 1) return truck_weights.length + 1;
        // 트럭 대수가 한대면 다리 길이 + 1만큼 시간이 걸린다
        if(truck_weights.length == 1) return bridge_length + 1;
        
        int idx = 0;
        int curWeight = 0;
        while(idx < truck_weights.length){
            curWeight -= queue.poll();
            answer++;
            
            // 현재 다리 무게와 비교하여 트럭을 올릴 수 있을만큼 올림
            if(curWeight + truck_weights[idx] <= weight){
                queue.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } else{
                // 무게를 못 견딜 경우는 0을 추가함
                queue.offer(0);
            }
        }
        // 마지막 트럭도 다리를 건너는 경우를 생각해야 함
        return answer + bridge_length;
    }
}