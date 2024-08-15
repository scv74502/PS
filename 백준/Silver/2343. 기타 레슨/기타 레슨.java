import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int N, M, ans;
        int totPlayTime = 0;
        ans = 0;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        int[] videos = new int[N];
        ipts = br.readLine().split(" ");
        int l = 0;

        for(int i = 0; i < N; i++){
            videos[i] = Integer.parseInt(ipts[i]);
            if(l < videos[i]){
                l = videos[i];
            }
            totPlayTime += videos[i];
        }      

        int[] accSum = new int[N];
        accSum[0] = videos[0];

        for(int i = 1; i < N; i++){
            accSum[i] = videos[i] + accSum[i-1];
        }


        int r = totPlayTime;

        while(l <= r){
            int mid = (l + r) / 2;

            // 블루레이에 강의를 녹화함
            int cnt = 0;
            int sum = 0;

            for(int i = 0; i < N; i++){
                if(sum + videos[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += videos[i];
            }
            if(sum != 0){
                cnt++;
            }
            if(cnt > M){
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
}
