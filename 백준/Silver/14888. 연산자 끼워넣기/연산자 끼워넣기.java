import java.io.*;

public class Main {
    public static int N, M;
    public static int min_val = Integer.MAX_VALUE;
    public static int max_val = Integer.MIN_VALUE;
    public static int[] opernands = new int [4];
    public static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        ipts = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(ipts[i]);
        }

        ipts = br.readLine().split(" ");

        for(int i = 0; i < 4; i++){
            opernands[i] = Integer.parseInt(ipts[i]);
        }

        dfs(1, numbers[0]);

        System.out.println(max_val);
        System.out.println(min_val);
    }

    public static void dfs(int depth, int cur){
        if(depth == N){
            min_val = Math.min(cur, min_val);
            max_val = Math.max(cur, max_val);
            return;
        }

        if(opernands[0] > 0){
            opernands[0]--;
            dfs(depth+1, cur+numbers[depth]);
            opernands[0]++;
        }

        if(opernands[1] > 0){
            opernands[1]--;
            dfs(depth+1, cur-numbers[depth]);
            opernands[1]++;
        }

        if(opernands[2] > 0){
            opernands[2]--;
            dfs(depth+1, cur*numbers[depth]);
            opernands[2]++;
        }

        if(opernands[3] > 0){
            opernands[3]--;
            dfs(depth+1, cur/numbers[depth]);
            opernands[3]++;
        }
    }
}
