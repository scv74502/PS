import java.io.*;

public class Main {
    static int[][] statArr;
    static int maxDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        statArr = new int[N][N];
        boolean[][] checked = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] ipt = br.readLine().split(" ");
            for (int j = 0; j < N; j++){
                statArr[i][j] = Integer.parseInt(ipt[j]);
            }
        }

        int[] team = new int[N];

        bt(0, 0, team, statArr);
        System.out.println(maxDiff);
    }

    public static void bt(int idx, int teamSum, int[] team, int[][] statArr){
        int N = statArr.length;

        if(teamSum == N / 2){
            int start = 0;
            int link = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int cnt = team[i] + team[j];
                    if(cnt == 2){
                        start += statArr[i][j] + statArr[j][i];
                    } else if (cnt == 0){
                        link += statArr[i][j] + statArr[j][i];
                    }
                }
            }

            maxDiff = Math.min(maxDiff, Math.abs(start - link));
            return;
        }

        for (int i = idx; i < team.length; i++){
            team[i] = 1;
            bt(i + 1, teamSum + 1, team, statArr);
            team[i] = 0;
        }
    }
}
