import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts;

        int TC = Integer.parseInt(br.readLine());
        int[] behindCount;
        int[][] scoreRanks;
        int[][] interviewRanks;

        for (int rpt = 0; rpt < TC; rpt++) {
            int answer = 1;
            int N = Integer.parseInt(br.readLine());

            behindCount = new int[N];
            scoreRanks = new int[N][3];


            for (int i = 0; i < N; i++) {
                ipts = br.readLine().split(" ");
                scoreRanks[i][0] = Integer.parseInt(ipts[0]);
                scoreRanks[i][1] = Integer.parseInt(ipts[1]);
                scoreRanks[i][2] = i;
            }

            if(N == 1){
                System.out.println(1);
                continue;
            }

            Arrays.sort(scoreRanks, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });

//            System.out.println(Arrays.deepToString(scoreRanks));
            int max = scoreRanks[0][1];

            for (int i = 1; i < N; i++) {
                if(scoreRanks[i][1] < max){
                    answer++;
                    max = scoreRanks[i][1];
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}
