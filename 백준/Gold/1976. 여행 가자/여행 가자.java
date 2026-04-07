import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    union(i, j);
                }
            }
        }

        String[] iptArr = br.readLine().split(" ");
        int[] plans = new int[iptArr.length];

        for (int i = 0; i < iptArr.length; i++) {
            plans[i] = Integer.parseInt(iptArr[i]);
        }

        int startRoot = find(plans[0]);
        for (int i = 1; i < plans.length; i++) {
            if (startRoot != find(plans[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
