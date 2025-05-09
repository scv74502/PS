import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n, k, t, m;
        int id, j, score;

        int TC = Integer.parseInt(br.readLine());

        for (int CASE = 0; CASE < TC; CASE++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 제출 횟수
            int[] submitCnt = new int[n+1];

            // 마지막 제출 시간
            int[] lastSubmit = new int[n+1];
            Arrays.fill(lastSubmit, m+1);

            HashMap<Integer, int[]> scoreMap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                scoreMap.put(i, new int[k+1]);
            }

            for (int turn = 1; turn <= m; turn++) {
                st = new StringTokenizer(br.readLine());
                id = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                score = Integer.parseInt(st.nextToken());

                scoreMap.get(id)[j] = Math.max(scoreMap.get(id)[j], score);
                submitCnt[id]++;
                lastSubmit[id] = turn;
            }

            int[][] ranks = new int[n][4];

            for (int i = 1; i <= n; i++) {
                ranks[i-1][0] = i;
                for (int l = 1; l <= k; l++) {
                    ranks[i-1][1] += scoreMap.get(i)[l];
                }
                ranks[i-1][2] = submitCnt[i];
                ranks[i-1][3] = lastSubmit[i];
            }

            Arrays.sort(ranks, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[1] != o1[1]){
                        return o2[1] - o1[1];
                    }

                    if(o2[2] != o1[2]){
                        return o1[2] - o2[2];
                    }


                    return o1[3] - o2[3];
                }
            });

            for (int i = 1; i <= n; i++) {
                if(ranks[i-1][0] == t){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}