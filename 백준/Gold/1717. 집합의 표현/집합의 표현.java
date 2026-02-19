import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] iptArr = br.readLine().split(" ");
        int N = Integer.parseInt(iptArr[0]);
        int M = Integer.parseInt(iptArr[1]);

        // 부모 노드 초기화
        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;  // 초기 부모노드는 자신
        }

        for (int i = 0; i < M; i++) {
            iptArr = br.readLine().split(" ");
            int command = Integer.parseInt(iptArr[0]);
            int o1 = Integer.parseInt(iptArr[1]);
            int o2 = Integer.parseInt(iptArr[2]);

            if (command == 0) {
                union(parent, o1, o2);
            } else {
                int root1 = find(parent, o1);
                int root2 = find(parent, o2);

                if(root1 == root2) sb.append("YES");
                else sb.append("NO");

                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    public static void union(int[] parent, int o1, int o2) {
        int root1 = find(parent, o1);
        int root2 = find(parent, o2);

        if (root1 <= root2) parent[root2] = root1;
        else parent[root1] = root2;
    }

    public static int find(int[] parent, int o1){
        if (parent[o1] == o1) return o1;

        parent[o1] = find(parent, parent[o1]);
        return parent[o1];
    }
}

