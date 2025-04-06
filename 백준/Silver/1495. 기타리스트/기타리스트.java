import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] volumes = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }


        HashSet<Integer>[] dp = new HashSet[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = new HashSet<Integer>();
        }

        dp[0].add(S);

        for (int i = 1; i <= N; i++) {
            if(dp[i - 1].isEmpty()) break;

            for(int vol: dp[i-1]){
                int upVol = vol + volumes[i];
                int downVol = vol - volumes[i];

                if(upVol <= M) dp[i].add(upVol);
                if(0 <= downVol) dp[i].add(downVol);
            }
        }

        int answer = -1;
        if(dp[N].isEmpty()) System.out.println(answer);
        else{
            for(int vol: dp[N]){
                answer = Math.max(vol, answer);
            }

            System.out.println(answer);
        }
    }
}
