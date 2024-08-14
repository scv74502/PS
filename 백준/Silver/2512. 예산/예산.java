import java.io.*;
import java.util.*;

public class Main {
    public static int bisect(int l, int r, int limit){
        int mid = (l + r) / 2;
        if(r <= limit){
            return limit;
        }else if (limit < l){
            return limit;
        }

        while(l < r){
            if(mid == limit){
                return mid;
            } else if(mid < limit){
                l = mid;
            } else{
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int answer = 0, result;

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N+2];
        ipts = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            budgets[i+1] = Integer.parseInt(ipts[i]);
        }

        int M = Integer.parseInt(br.readLine());
        budgets[N+1] = M;
        int limit = M;

        Arrays.sort(budgets);

        for(int i = 0; i < N; i++){
            limit -= budgets[i];
            answer = Math.max(answer, bisect(budgets[i], budgets[i+1], limit / (N-i)));
        }

        System.out.println(Math.min(answer, budgets[N]));
    }
}
