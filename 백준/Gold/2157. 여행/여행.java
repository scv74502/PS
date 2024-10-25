import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int K = Integer.parseInt(ipts[2]);

        int[][] distance = new int[N+1][M+1];
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            ipts = br.readLine().split(" ");
            int a = Integer.parseInt(ipts[0]);
            int b = Integer.parseInt(ipts[1]);
            int c = Integer.parseInt(ipts[2]);

            if(a > b) continue;

            // 같은 거리가 여러가지인 경우가 있으므로 최대값 최함
//            adjList[a][b] = Math.max(c, adjList[a][b]);
            adj.get(a).add(new int[] {b,c});
        }

        int nextCity, score;

        // 초기화로 시작, 1번부터 출발하면 도시 2개 여행함
        for(int[] cur:adj.get(1)){
            nextCity = cur[0];
            score = cur[1];
            distance[nextCity][2] = Math.max(distance[nextCity][2], score);
        }


        for(int i = 2; i < M; i++) {
            for(int j = 2; j <= N; j++) {
                // 방문한 적 없는 도시는 체크하지 않는다
                if(distance[j][i] != 0){
                    for(int[] cur:adj.get(j)){
                        nextCity = cur[0];
                        score = cur[1];
                        distance[nextCity][i+1] = Math.max(distance[nextCity][i+1], distance[j][i] + score);
                    }
                }
            }
        }


        int answer = 0;
        for (int i = 1; i <= M; i++) {
            answer = Math.max(answer, distance[N][i]);
        }

        System.out.println(answer);
    }
}
