import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] leftday = new int[speeds.length];
        // 줄 서는 자료구조인 큐를 통해 첫날의 남은 일수부터 주입함
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < speeds.length; i++){
            int progress = progresses[i];
            int day = 0;
            
            while(progress < 100){
                day += 1;
                progress += speeds[i];
            }
            leftday[i] = day;
            queue.offer(day);
        }
        // System.out.println(Arrays.toString(leftday));
        
        int tmp = 0;
        int count = 0;
        
        while(!queue.isEmpty()){
            // 가장 최근 날자를 확인하여 현재 남은 일수와 비교하여
            if(tmp > queue.peek()){
                queue.poll();
            } else{
                tmp = queue.poll();
            }
            count++;
            
            // 모든 일자를 검사한 후의 마지막 값이라면
            if(queue.isEmpty()){
                ans.add(count);
            } else if (queue.peek()> tmp){
                ans.add(count);
                count = 0;
                tmp = 0;
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}