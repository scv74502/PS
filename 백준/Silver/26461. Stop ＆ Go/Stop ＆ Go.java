import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        // 신호등 개수, 도로 길이, 신호등 위치,
        int N, L, loc, gtr, rtg, cost, left;
        long time = 0;
        int curLoc = 0;
        ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        L = Integer.parseInt(ipts[1]);
        int[] trafficLightLocs = new int[N];
        HashMap<Integer, TrafficLights> hm = new HashMap<>();

        for(int i = 0; i < N; i++){
            ipts = br.readLine().split(" ");
            loc = Integer.parseInt(ipts[0]);
            gtr = Integer.parseInt(ipts[1]);
            rtg = Integer.parseInt(ipts[2]);
            hm.put(loc, new TrafficLights(true, 0, gtr, rtg));
            trafficLightLocs[i] = loc;
        }

        Arrays.sort(trafficLightLocs);

        for(int trafficLightLoc:trafficLightLocs){
            // 이동
            cost = trafficLightLoc - curLoc;
            time += cost;
            curLoc = trafficLightLoc;

            gtr = hm.get(trafficLightLoc).gtr;
            rtg = hm.get(trafficLightLoc).rtg;

            left = (int) (time % (gtr + rtg));
            // 초록불이면
            if(left < gtr){
                continue;
            } else{
                time += rtg - (left - gtr);
            }
        }

        time += L - curLoc;

        System.out.println(time);
    }

    public static class TrafficLights{
        boolean isGreen;
        int curTime;
        int gtr;
        int rtg;

        public TrafficLights(boolean isGreen, int curTime, int gtr, int rtg) {
            this.isGreen = isGreen;
            this.curTime = curTime;
            this.gtr = gtr;
            this.rtg = rtg;
        }

//        @Override
//        public int compareTo(TrafficLights o1){
//            if(this.location >= o1.location){
//                return 1;
//            } else{
//                if(this.isGreen){
//                    return 1;
//                } else{
//                    return -1;
//                }
//            }
//        }

        @Override
        public String toString() {
            return "TrafficLights{" +
                    "isGreen=" + isGreen +
                    ", curTime=" + curTime +
                    ", gtr=" + gtr +
                    ", rtg=" + rtg +
                    '}';
        }
    }
}