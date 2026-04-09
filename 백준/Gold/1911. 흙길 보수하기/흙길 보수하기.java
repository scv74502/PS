import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] holes = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            holes[i][0] = start;
            holes[i][1] = end;
        }

        Arrays.sort(holes, Comparator.comparingInt((int[] o) -> o[0])
                .thenComparingInt((int[] o) -> o[1]));

        int answer = 0;
        int lastCovered = 0;

        for (int i = 0; i < N; i++) {
            int start = holes[i][0];
            int end = holes[i][1];

            if(lastCovered >= end) continue;

            int usedBoardAmount = getRequiredBoard(L, start >= lastCovered ? end - start : end - lastCovered);
            answer += usedBoardAmount;
            lastCovered = start >= lastCovered ? start + L * usedBoardAmount : lastCovered + L * usedBoardAmount;
        }

        System.out.println(answer);
    }

    static int getRequiredBoard(int L, int size){
        int answer = size / L;
        if(size % L > 0) return answer + 1;
        return answer;
    }
}

