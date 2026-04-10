import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {        
        int foodMenuCnt = food_times.length;
        long eatingTime = 0L;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));                
        
        for(int i = 0; i < foodMenuCnt; i++) {
            pq.add(new int[] {food_times[i], i});
            eatingTime += food_times[i];
        }
        
        if(eatingTime <= k) return -1;
        
        long previousTime = 0;
        long remains = foodMenuCnt;
        
        while (!pq.isEmpty()) {
            // (현재 음식 시간 - 이전 음식 시간)을 long으로 형변환
            long currentFoodTime = pq.peek()[0];
            long spendTime = (currentFoodTime - previousTime) * remains;

            if (spendTime <= k) {
                k -= spendTime;
                previousTime = currentFoodTime;
                remains--;
                pq.poll();
            } else {
                // 더 이상 통째로 뺄 수 없으면 중단
                break;
            }
        }
        
        // 남은 음식을 리스트로 옮기기
        List<int[]> emptyFoods = new ArrayList<>();
        while (!pq.isEmpty()) {
            emptyFoods.add(pq.poll());
        }

        // 원래 인덱스 순으로 정렬
        emptyFoods.sort((a, b) -> Integer.compare(a[1], b[1]));

        // k초 후 먹을 음식 반환
        return emptyFoods.get((int)(k % remains))[1] + 1;
    }
}