import java.util.*;
    
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 정답 시간
        int answer = 0;
        
        // 다리 위 트럭 무게 합
        int sum = 0;
        
        // 큐를 생성
        Queue<Integer> bridge = new LinkedList<>();
        
        // 매 트럭마다 체크하기
        for(int truck:truck_weights){
            while(true){
                // 다리가 비어 있으면
                if(bridge.isEmpty()){
                    // 다리에 트럭을 올리고
                    bridge.offer(truck);
                    sum += truck;
                    answer++;   // 트럭이 오르면 시간도 체크함
                    break;  // while문 종료 후 반복문 다음으로 넘김
                // 큐의 길이가 다리 길이와 같아면(빈 공간이건 트럭이건 다리 위 칸이 다 찼다면 빼내야 함)
                } else if(bridge.size() == bridge_length){
                    sum -= bridge.poll();                }
                // 다리가 비어있지 않으면
                else{
                    if(sum + truck <= weight){
                        bridge.offer(truck);
                        sum += truck;
                        answer++;   // 트럭이 오르면 시간도 체크함
                        break;  // while문 종료 후 반복문 다음으로 넘김
                    } else{
                        bridge.offer(0);                        
                        answer++;   // 트럭이 오르면 시간도 체크함
                        // 이 경우는 시간만 증가하고 반복문이 종료되지 않는다는 것 유의하기
                    }
                }
            }            
        }
        // 이 상태는 마지막 트럭이 큐에 있는 상태로 끝난다
        // 설사 마지막 트럭 바로 앞에 트럭이 있었더라도, 마지막 트럭이 다리를 완전히 건너야 문제의 조건이 끝나므로 무시할 수 있음            
        return answer + bridge_length;
    }
}