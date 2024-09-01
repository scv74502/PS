import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int u, v, result;
        int rpt = 1;
        while(true){
            ipts = br.readLine().split(" ");
            if(ipts[0].equals("0") && ipts[1].equals("0")){
                break;
            }
            sb.append("Case ");
            sb.append(rpt);
            sb.append(": ");

            N = Integer.parseInt(ipts[0]);
            M = Integer.parseInt(ipts[1]);
            visited = new boolean[N+1];

            graph = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < M; i++){
                ipts = br.readLine().split(" ");
                u = Integer.parseInt(ipts[0]);
                v = Integer.parseInt(ipts[1]);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            result = findTree();

            if(result > 1){
                sb.append("A forest of ");
                sb.append(result);
                sb.append(" trees.\n");
            } else if(result == 1){
                sb.append("There is one tree.\n");
            } else{
                sb.append("No trees.\n");
            }
            rpt++;
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static int findTree(){
        int result = 0;
        boolean isCycle;
        int cur;
        ArrayDeque<Integer> dq;
        for(int i = 1; i <= N; i++){
            isCycle = false;
            if(!visited[i]){
                dq = new ArrayDeque<>();
                dq.add(i);

                while(!dq.isEmpty()){
                    cur =  dq.poll();
                    // 사이클이 있으면 중단하고 다음 정점 체크
                    if(visited[cur]){
                        isCycle = true;
                    }

                    visited[cur] = true;

                    for(int num:graph.get(cur)){
                        if(!visited[num]){
                            dq.add(num);
                        }
                    }
                }
                if(!isCycle){
                    result++;
                }
            }
        }
        return result;
    }
}
