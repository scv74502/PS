import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        int N = Integer.parseInt(br.readLine());

        boolean[][] connected = new boolean[N][N];
        boolean[][] graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            ipt = br.readLine();
            for (int j = 0; j < ipt.length(); j++) {
                if(ipt.charAt(j) == 'Y'){
                    graph[i][j] = true;
                    connected[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(i == j) continue;
                    if(graph[i][j] || (graph[i][k] && graph[k][j])) connected[i][j] = true;
                }
            }
        }


        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(connected[i][j]) cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);
    }
}
