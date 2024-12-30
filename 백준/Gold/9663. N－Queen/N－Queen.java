import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int depth){
        if(depth == N){
            answer++;
            return;
        }

        // depth 열의 i행을 체크
        for (int i = 0; i < N ; i++) {
            arr[depth] = i;
            if(isAvailable(depth)){
                dfs(depth+1);
            }
        }
    }

    public static boolean isAvailable(int col){
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치하다면
            if(arr[col] == arr[i]) return false;
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }
}
