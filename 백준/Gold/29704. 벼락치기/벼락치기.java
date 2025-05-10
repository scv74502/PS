import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] days = new int[N];
        int[] panelties = new int[N];

        int[][] knapsack = new int[N+1][M+1];
        int maxPanelty = 0;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(stringTokenizer.nextToken());
            panelties[i] = Integer.parseInt(stringTokenizer.nextToken());
            maxPanelty += panelties[i];
        }

        for (int i = 1; i <= N; i++) {
            int day = days[i-1];
            int panelty = panelties[i-1];

            for (int j = 1; j <= M; j++) {
                knapsack[i][j] = knapsack[i-1][j];  // 아무 것도 하지 않아도 이전 선택 값을 유지한다

                if(j >= day){   // 현재 날짜가 현재 소요시간 뒤라면
                    knapsack[i][j] = Math.max(knapsack[i][j], knapsack[i-1][j-day] + panelty);
                }
            }
        }

        System.out.println(Math.max(maxPanelty - knapsack[N][M], 0));
    }
}
