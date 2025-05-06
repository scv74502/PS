import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladderAndSnake = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ladderAndSnake.put(u, v);
        }

        int[] visitCnt = new int[101];
        Arrays.fill(visitCnt, Integer.MAX_VALUE);
        visitCnt[1] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == 100){
                break;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;
                if(next > 100) continue;

                if(ladderAndSnake.containsKey(next)){
                    next = ladderAndSnake.get(next);
                }

                if(visitCnt[cur] + 1 >= visitCnt[next]) continue;

                visitCnt[next] = visitCnt[cur] + 1;
                queue.add(next);
            }
        }

        System.out.println(visitCnt[100]);
    }
}
