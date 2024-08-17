import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] dp = new int[N + 1];
        int answer = 0;

        for(int i = 1; i <= N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // idx 0부터 시작한다 하고 (i>2)일때 dp[i][0] dp[i][1]
        // 1. i층이라 가정할 때 i-2번에서 i층으로 두 칸 오르거나, i-3층에서 i-1층을 밟고 i층으로 오르거나 두 종류이다
        if(N <= 2){
            for(int i = 0; i <= N; i++){
                answer += stairs[i];
            }
            System.out.println(answer);
        } else{
            dp[0] = 0;
            dp[1] = stairs[1];
            dp[2] = dp[1] + stairs[2];
            for(int i = 3; i <= N; i++){
                dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
            }
            System.out.println(dp[N]);
        }
    }
}
