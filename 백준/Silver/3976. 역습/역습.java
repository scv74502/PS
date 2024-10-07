import java.io.*;

public class Main{
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, l1, l2, s1, s2, pass, dribble;

        String[] ipts;
        int[] striker1Pass;
        int[] striker1Dribble;
        int[] striker2Pass;
        int[] striker2Dribble;;
        int[][] dp;

        int tc = Integer.parseInt(br.readLine());
        for(int rpt = 0; rpt < tc; rpt++){
            ipts = br.readLine().split(" ");
            n = Integer.parseInt(ipts[0]);
            l1 = Integer.parseInt(ipts[1]);
            l2 = Integer.parseInt(ipts[2]);
            s1 = Integer.parseInt(ipts[3]);
            s2 = Integer.parseInt(ipts[4]);

            striker1Pass = new int[n-1];
            striker1Dribble = new int[n-1];
            striker2Pass = new int[n-1];
            striker2Dribble = new int[n-1];

            ipts = br.readLine().split(" ");
            for(int i = 0; i < n-1; i++){
                striker1Pass[i] = Integer.parseInt(ipts[i]);
            }

            ipts = br.readLine().split(" ");
            for(int i = 0; i < n-1; i++){
                striker1Dribble[i] = Integer.parseInt(ipts[i]);
            }

            ipts = br.readLine().split(" ");
            for(int i = 0; i < n-1; i++){
                striker2Pass[i] = Integer.parseInt(ipts[i]);
            }

            ipts = br.readLine().split(" ");
            for(int i = 0; i < n-1; i++){
                striker2Dribble[i] = Integer.parseInt(ipts[i]);
            }

            // dp[0]의 두 값은 스트라이커 1, 2의 초기값
            dp = new int[n][2];
            dp[0][0] = l1;
            dp[0][1] = l2;

            // 점화식은 2가지가 있다, i번째 점에서의 스트라이커 1, 2번 최소 난이도
            // 1번 스트라이커 i번째위치 최소난이도는 dp[i][0] = Min(dp[i-1][0] + striker1Dribble[i-1], dp[i-1][1] + striker2Pass[i-1])
            // 2번 스트라이커 i번째위치 최소난이도는 dp[i][1] = Min(dp[i-1][0] + striker1Pass[i-1], dp[i-1][1] + striker2Dribble[i-1])

            for(int i = 1; i <= n-1; i++){
                dp[i][0] = Math.min(dp[i-1][0] + striker1Dribble[i-1], dp[i-1][1] + striker2Pass[i-1]);
                dp[i][1] = Math.min(dp[i-1][0] + striker1Pass[i-1], dp[i-1][1] + striker2Dribble[i-1]);
            }

            System.out.println(Math.min(dp[n-1][0] + s1, dp[n-1][1] + s2));
        }
    }
}
