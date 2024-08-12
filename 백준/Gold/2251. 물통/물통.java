import java.io.*;
import java.util.*;

public class Main {
    public static int A, B, C;
    public static HashSet<Integer> hs;
    // StringBuilder static
    public static StringBuilder sbs = new StringBuilder();
    public static String toKey(int a, int b, int c){
        sbs.append(a);
        sbs.append(b);
        sbs.append(c);
        String result = sbs.toString();
        sbs.setLength(0);

        return result;
    }

    public static void bfs(int a, int b, int c){
        HashSet<String> visited = new HashSet<>();
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {a, b, c});

        int ca, cb, cc, water;
        int na, nb, nc;
        String key;
        //visited.add(toKey(a, b, c));

        while(!dq.isEmpty()){
            ca = dq.peek()[0];
            cb = dq.peek()[1];
            cc = dq.peek()[2];
            dq.pollFirst();

            if(ca == 0){
                hs.add(cc);
                visited.add(toKey(ca, cb, cc));
            }



            // a의 물을 B 물통에 부음(물이 B보다 많은 케이스와 적거나 같은 케이스)
            if(ca > B - cb){
                water = ca - (B - cb);
                na = water;
                nb = B;
                nc = cc;
                key = toKey(na, nb, nc);

            } else{
                water = cb + ca;
                na = 0;
                nb = water;
                nc = cc;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (na == 0 || nb == B)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }

            // a의 물을 C 물통에 부음(물이 C보다 많은 케이스와 적거나 같은 케이스)
            if(ca > C - cc){
                water = ca - (C - cc);
                na = water;
                nb = cb;
                nc = C;
                key = toKey(na, nb, nc);
            } else{
                water = ca + cc;
                na = 0;
                nb = cb;
                nc = water;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (na == 0 || nc == C)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }


            // B의 물을 A 물통에 부음(물이 A보다 많은 케이스와 적거나 같은 케이스)
            if(cb > A - ca){
                water = cb - (A - ca);
                na = A;
                nb = water;
                nc = cc;
                key = toKey(na, nb, nc);
            } else{
                water = ca + cb;
                na = water;
                nb = 0;
                nc = cc;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (nb == 0 || na == A)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }


            // B의 물을 C 물통에 부음(물이 C보다 많은 케이스와 적거나 같은 케이스)
            if(cb > C - cc){
                water = cb - (C - cc);
                na = ca;
                nb = water;
                nc = C;
                key = toKey(na, nb, nc);
            } else{
                water = cc + cb;
                na = ca;
                nb = 0;
                nc = water;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (nb == 0 || nc == C)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }


            // C의 물을 A 물통에 부음(물이 A보다 많은 케이스와 적거나 같은 케이스)
            if(cc > A - ca){
                water = cc - (A - ca);
                na = A;
                nb = cb;
                nc = water;
                key = toKey(na, nb, nc);
            } else{
                water = cc + ca;
                na = water;
                nb = cb;
                nc = 0;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (nc == 0 || na == A)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }

            // C의 물을 B 물통에 부음(물이 B보다 많은 케이스와 적거나 같은 케이스)
            if(cc > B - cb){
                water = cc - (B - cb);
                na = ca;
                nb = B;
                nc = water;
                key = toKey(na, nb, nc);
            } else{
                water = cc + cb;
                na = ca;
                nb = water;
                nc = 0;
                key = toKey(na, nb, nc);
            }

            if(!visited.contains(key) && (nc == 0 || nb == B)){
                dq.add(new int[] {na, nb, nc});
                visited.add(key);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        A = Integer.parseInt(ipts[0]);
        B = Integer.parseInt(ipts[1]);
        C = Integer.parseInt(ipts[2]);
        hs = new HashSet<>();

        bfs(0, 0, C);
        PriorityQueue<Integer> pq = new PriorityQueue<>(hs);

        while(!pq.isEmpty()){
            sbs.append(pq.poll());
            if(pq.peek() != null){
                sbs.append(" ");
            }
        }
        bw.write(sbs.toString());
        bw.flush();
    }
}
