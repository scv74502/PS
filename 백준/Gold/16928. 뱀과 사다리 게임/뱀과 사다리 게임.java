import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladderAndSnake = new HashMap<>(N+M+1);

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            ladderAndSnake.put(u, v);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int answer = Integer.MAX_VALUE;

        int[] visitCnt = new int[101];
        Arrays.fill(visitCnt, -1);
        visitCnt[1] = 0;

        while(!queue.isEmpty()){
            int curLoc = queue.poll();

            if(curLoc == 100){
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nextLoc = curLoc + i;

                if(nextLoc > 100) continue;


                if(ladderAndSnake.containsKey(nextLoc)){
                    nextLoc = ladderAndSnake.get(nextLoc);
                }

                if(visitCnt[nextLoc] == -1){
                    visitCnt[nextLoc] = visitCnt[curLoc] + 1;
                    queue.add(nextLoc);
                }
            }
        }

        System.out.println(visitCnt[100]);
    }
}
