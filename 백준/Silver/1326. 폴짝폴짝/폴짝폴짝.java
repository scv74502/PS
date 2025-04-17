import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] bridge = new int[N+1];
        boolean[] visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {a, 0});
        visited[a] = true;

        int answer = -1;
        
        while(!queue.isEmpty()){
            int cur = queue.peek()[0];
            int curTurn = queue.peek()[1];
            queue.poll();

            if(cur == b){
                answer = curTurn;
                break;
            }

            for (int i = 1; cur + i * bridge[cur] <= N; i++) {
                int next = cur + i * bridge[cur];
                if(visited[next]) continue;
                queue.add(new int[] {next, curTurn + 1});
                visited[next] = true;
            }

            for (int i = 1; cur - i * bridge[cur] > 0; i++) {
                int next = cur - i * bridge[cur];
                if(visited[next]) continue;
                queue.add(new int[] {next, curTurn + 1});
                visited[next] = true;
            }
        }

        if(queue.isEmpty() && answer == -1){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }
}
