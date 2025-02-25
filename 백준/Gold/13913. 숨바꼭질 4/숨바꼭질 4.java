import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] pathRecord;
    static int[] dist = new int[100_001];
    static int[] move = new int[] {-1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pathRecord = new int[100_001];
        Arrays.fill(dist, -1);
        Arrays.fill(pathRecord, -1);
        bfs(N, K);

        ArrayList<Integer> path = new ArrayList<>();
        int current = K;
        while(current != -1) {
            path.add(current);
            current = pathRecord[current];
        }
        Collections.reverse(path);

        bw.write(path.size() - 1 + "\n");
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1) {
                bw.write(path.get(i) + "\n");
            } else {
                bw.write(path.get(i) + " ");
            }
        }

        bw.flush();
    }

    public static void bfs(int start, int end){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        pathRecord[start] = -1;  // 시작점의 이전 노드는 없음
        queue.add(start);

        while(!queue.isEmpty()){
            int curLoc = queue.poll();

            if(curLoc == end){
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nextLoc = curLoc + move[i];
                if(i == 2) nextLoc = curLoc * 2;

                if(nextLoc < 0 || 100_000 < nextLoc) continue;

                if(dist[nextLoc] == -1){
                    dist[nextLoc] = dist[curLoc] + 1;
                    pathRecord[nextLoc] = curLoc;  // 경로 저장
                    queue.add(nextLoc);
                }
            }
        }
    }
}
