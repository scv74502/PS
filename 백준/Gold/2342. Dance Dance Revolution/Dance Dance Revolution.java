import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] dices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");
        int N = ipts.length - 1;
        final int MAX = 400000;

        if(N == 0){
            System.out.println(0);
            return;
        }

        int[] move = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            move[i] = Integer.parseInt(ipts[i-1]);
        }

        int[][][] dp = new int[N + 1][5][5];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, MAX + 1);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i <= N; i++) {
            int target = move[i];

            // 오른발 고정, 왼발이 움직임
            for (int r = 0; r < 5; r++) {
                for (int k = 0; k < 5; k++) {
                    int cost = getCost(k, target);
                    dp[i][target][r] = Math.min(dp[i][target][r], dp[i-1][k][r] + cost);
                }
            }

            // 왼발 고정, 오른발이 움직임
            for (int l = 0; l < 5; l++) {
                for (int k = 0; k < 5; k++) {
                    int cost = getCost(k, target);
                    dp[i][l][target] = Math.min(dp[i][l][target], dp[i-1][l][k] + cost);
                }
            }
        }

        int answer = MAX+1;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[N][l][r]);
            }
        }

        System.out.println(answer);

    }

    static int getCost(int start, int end){
        int dist = Math.abs(start - end);
        if(start == 0){
            if(end == 0) return 1;
            else return 2;
        }
        else if(start == end) return 1;
        else if(dist == 1 || dist == 3) return 3;
        else return 4;
    }
}
