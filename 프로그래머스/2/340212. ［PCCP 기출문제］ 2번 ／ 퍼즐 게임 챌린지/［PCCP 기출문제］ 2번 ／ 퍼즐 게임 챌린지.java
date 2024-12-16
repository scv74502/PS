import java.util.*;

class Solution {
    static int[][] puzzles;
    public int solution(int[] diffs, int[] times, long limit) {
        puzzles = new int[diffs.length][2];
        int maxLevel = 0;

        for(int i = 0; i < diffs.length; i++){
            puzzles[i][0] = diffs[i];
            puzzles[i][1] = times[i];

            if(diffs[i] > maxLevel){
                maxLevel = diffs[i];
            }
        }

        int answer = bisect(limit, maxLevel);
        return answer > 0 ? answer : 1;
    }

    public static int bisect(long limit, int right){
        int left = 0;
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;
            if(getTime(mid) <= limit){
                right = mid;
            } else if(getTime(mid) >= limit){
                left = mid + 1;
            }

        }
        return right;
    }

    public static long getTime(int level){
        long time_cur, time_prev, diff, time;
        time_prev = 0;
        long total_time = 0;
        for(int[] puzzle:puzzles){
            diff = puzzle[0];
            time_cur = puzzle[1];

            if(diff <= level){
                total_time += time_cur;
            } else{
                total_time += ((time_cur + time_prev) * (diff - level) + time_cur);
            }
            time_prev = time_cur;
        }

        return total_time;
    }
}

