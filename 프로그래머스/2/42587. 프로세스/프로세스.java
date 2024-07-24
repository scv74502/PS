import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        Process curP;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Deque<Process> dq = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            Process process = new Process(priorities[i], i);
            pq.add(process);
            dq.add(process);
        }

        while(!dq.isEmpty()){
            if(pq.peek().priority == dq.peek().priority){
                cnt += 1;
                pq.poll();
                curP = dq.pop();
                if(curP.location == location){
                    return cnt;
                }
            }
            else{
                dq.add(dq.pop());
            }
        }
        return cnt;
    }
}

class Process implements Comparable<Process>{
    public int priority;
    public int location;
    public Process(int priority, int location){
        this.priority = priority;
        this.location = location;
    }

    @Override
    public int compareTo(Process process){
        if(this.priority < process.priority){
            return 1;
        }
        else if(this.priority == process.priority){
            if(this.location > process.location){
                return 1;
            } else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    @Override
    public String toString(){
        String result = "priority : " + this.priority + ", location : " + this.location;
        return result;
    }
}