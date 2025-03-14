import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class Main {
    static int N;
    static ArrayList<int[]>[] graph;
    static int[] times;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[N + 1];
            times = new int[N + 1];
            Arrays.fill(times, Integer.MAX_VALUE);
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }
            
            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                graph[u].add(new int[]{v, s});
            }
            
            dijkstra(c);
        }
    }
    
    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[] {0, start});
        times[start] = 0;
        
        while(!pq.isEmpty()){
            int[] curVertex = pq.poll();
            int cd = curVertex[0];
            int cv = curVertex[1];
            
            if (cd > times[cv]) continue;
            
            for (int[] nextVertex : graph[cv]) {
                int nv = nextVertex[0];
                int nd = nextVertex[1];
                
                if(times[cv] + nd < times[nv]){
                    times[nv] = times[cv] + nd;
                    pq.add(new int[] {times[nv], nv});
                }
            }
        }
        
        int infested = 0;
        int time = 0;
        
        for(int t:times){
            if(t == Integer.MAX_VALUE) continue;
            infested++;
            time = Math.max(t, time);
        }
        
        System.out.println(infested + " " + time);
    }
}