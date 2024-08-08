import java.io.*;
import java.util.*;

public class Main {
    public static int k;
    public static Long maxVal = (long) -1;
    public static Long minVal = Long.MAX_VALUE;
    public static String minRes, maxRes;
    public static String[] ieqs;
    public static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String ipt;

        k = Integer.parseInt(br.readLine());
        ieqs = br.readLine().strip().split(" ");

        for(int i = 0; i < 10; i++){
            visited[i] = true;
            dfs(0, Integer.toString(i) );
            visited[i] = false;
        }

        sb.append(maxRes);
        sb.append("\n");
        sb.append(minRes);
        bw.append(sb.toString());
        bw.flush();
    }

    public static void dfs(int depth, String number){
        if(depth == k){
            Long num = Long.parseLong(number);
            maxRes = maxVal > num ? maxRes : number;
            minRes = num > minVal ? minRes : number;
            maxVal = Math.max(num, maxVal);
            minVal = Math.min(num, minVal);
            return;
        }

        for(int i = 0; i < 10; i++){
            int curNum = Integer.parseInt(number.substring(number.length() - 1));
            if(ieqs[depth].equals(">")){
                if(!visited[i] && curNum > i){
                    visited[i] = true;
                    dfs(depth+1, number+Integer.toString(i));
                    visited[i] = false;
                }
            } else{
                if(!visited[i] && curNum < i){
                    visited[i] = true;
                    dfs(depth+1, number+Integer.toString(i));
                    visited[i] = false;
                }
            }
        }
    }
}
