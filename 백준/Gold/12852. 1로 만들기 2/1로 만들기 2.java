import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int dp[];
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        parent = new int[N + 1];
        Arrays.fill(dp, -1);
        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]);
        sb.append("\n");

        int cur = N;
        while(cur != 0){
            sb.append(cur);
            sb.append(" ");
            cur = parent[cur];
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dp[1] = 0;
        parent[0] = 1;

        while(!queue.isEmpty()){
            int curNum = queue.poll();
            if(curNum == N){
                return;
            }

            int[] nextNodes = {curNum + 1, curNum * 2, curNum * 3};
            for(int next:nextNodes){
                if(next <= N && dp[next] == -1){
                    queue.add(next);
                    dp[next] = dp[curNum] + 1;
                    parent[next] = curNum;
                }
            }
        }
    }
}
