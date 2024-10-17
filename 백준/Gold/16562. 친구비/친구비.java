import java.io.*;
import java.util.*;

public class Main {
    static int[] friendCosts;
    static int[] parent;
    static ArrayList<HashSet<Integer>> setList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int k = Integer.parseInt(ipts[2]);

        friendCosts = new int[N+1];
        parent = new int[N+1];

        ipts = br.readLine().split(" ");

        for(int i = 1; i <= N; i++) {
            friendCosts[i] = Integer.parseInt(ipts[i-1]);
        }

        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            ipts = br.readLine().split(" ");

            int u = Integer.parseInt(ipts[0]);
            int v = Integer.parseInt(ipts[1]);

            // 번호가 낮은 쪽으로 루트노드 만들기
            if(u > v) union(v, u);
            else union(u, v);
        }

        // 총 친구비
        long cnt = 0;
        // 중복 방지
        boolean[] visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++) {
            // 1~N까지 돌며 각 노드의 루트노드 찾음
            int idx = find(i);

            // 루트노드를 체크하지 않았다면 비용에 더하고 방문처리함
            if(!visited[idx]) {
                cnt += friendCosts[idx];
                visited[idx] = true;
            };
            // 현 노드도 방문처리함
            visited[i] = true;
        }

        if(cnt > k) System.out.println("Oh no");
        else System.out.println(cnt);
    }

    static int find(int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    static void union(int u, int v){
        u = find(u);
        v = find(v);

        // 비용이 낮은 쪽이 루트노드
        if(friendCosts[u] > friendCosts[v]){
            parent[u] = v;
        }

        // 아니면 번호가 낮은 쪽이 루트노드
        else parent[v] = u;
    }

    static boolean isUnion(int u, int v){
        u = find(u);
        v = find(v);

        return u == v;
    }
}
