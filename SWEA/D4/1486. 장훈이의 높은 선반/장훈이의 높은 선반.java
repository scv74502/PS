import java.io.*;
import java.util.Arrays;
 
public class Solution {
    static int N, B, minHeight, sArr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        String[] ipt;
        boolean[] visited;
 
        int tcnt = Integer.parseInt(br.readLine());
 
        for (int TC = 1; TC <= tcnt; TC++) {
            sb = new StringBuilder();
            ipt = br.readLine().split(" ");
            N = Integer.parseInt(ipt[0]);
            B = Integer.parseInt(ipt[1]);
            sArr = new int[N];
            visited = new boolean[N];
            ipt = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                sArr[i] = Integer.parseInt(ipt[i]);
            }
            minHeight = 200000;
            top(0, 0);
            sb.append("#").append(TC).append(" ").append(minHeight-B).append("\n");
            bw.write(sb.toString());
            bw.flush();
        }
    }
 
    public static void top(int idx, int height){
        if(B <= height && height < minHeight){
            minHeight = height;
        }
        if(idx == N){
            return;
        }
        top(idx+1, height);
        top(idx+1, height+sArr[idx]);
    }
}