import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] lines = new long[N][2];

        long x, y;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            lines[i][0] = x;
            lines[i][1] = y;
        }

        Arrays.sort(lines, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        long answer = 0;
        long cs = lines[0][0], ce = lines[0][1];
        for (int i = 0; i < N; i++) {
            if(lines[i][1] <= ce) continue;
            if(lines[i][0] <= ce) {
                ce = lines[i][1];
            } else{
                answer += ce - cs;
                cs = lines[i][0];
                ce = lines[i][1];
            }
        }

        answer += ce - cs;
        System.out.println(answer);
    }
}