import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        
        int[] degree = new int[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            degree[u]++;
            degree[v]++;
        }
        
        int leafCount = 0;
        
        // 루트 노드(1번)를 제외한 노드 중 연결된 간선이 1개인 노드가 리프 노드입니다.
        for (int i = 2; i <= N; i++) {
            if (degree[i] == 1) {
                leafCount++;
            }
        }
        
        // 정답 출력 (전체 물의 양 / 리프 노드의 개수)
        System.out.println(W / leafCount);
    }
}
