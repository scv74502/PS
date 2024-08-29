import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        int[] parent = new int[N + 1];
        int u, v, temp;

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++){
            ipts = br.readLine().split(" ");
            u = Integer.parseInt(ipts[0]);
            v = Integer.parseInt(ipts[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);

        int cur;
        while(!dq.isEmpty()){
            cur = dq.poll();
            for(int num:graph.get(cur)){
                if(parent[num] == 0 && num != 1){
                    parent[num] = cur;
                    dq.add(num);
                }
            }
        }

        for(int i = 2; i <= N; i++){
            sb.append(parent[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

