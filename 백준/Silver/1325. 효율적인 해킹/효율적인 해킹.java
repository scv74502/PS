import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList <Integer>[] connection;
    static boolean[] visited;
    static int[] countAffected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        visited = new boolean[N + 1];
        connection = new ArrayList[N + 1];
        countAffected = new int[N+1];

        int a, b;

        for (int i = 0; i < M; i++) {
            // a가 b를 신뢰한다 -> b를 해킹하면 a도 해킹된다
            ipts = br.readLine().split(" ");
            a = Integer.parseInt(ipts[0]);
            b = Integer.parseInt(ipts[1]);

            if(connection[a] == null){
                connection[a] = new ArrayList<Integer>();
            }
            connection[a].add(b);
        }

        for (int i = 1; i < N + 1; i++) {
            clearVisited();
            dfs(i);
        }

        int answer = 0;
        for (int i = 1; i < N+1; i++) {
            answer = Math.max(answer, countAffected[i]);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if(countAffected[i] == answer){
                sb.append(i);
                sb.append(" ");
            }
        }

        sb.setLength(sb.length() - 1);
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int start){
        visited[start] = true;
        if(connection[start] == null) return;
        for (int i: connection[start]) {
            if(visited[i]) continue;
            countAffected[i]++;
            dfs(i);
        }
    }

    public static void clearVisited(){
        for (int i = 0; i < N+1; i++) {
            visited[i] = false;
        }
    }
}
