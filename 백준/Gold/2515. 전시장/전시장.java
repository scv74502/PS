import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, S;
    static Painting[] paintingsArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        S = Integer.parseInt(ipts[1]);

        paintingsArr = new Painting[N];

        int h, c;
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            h = Integer.parseInt(ipts[0]);
            c = Integer.parseInt(ipts[1]);
            paintingsArr[i] = new Painting(h, c);
        }

        Arrays.sort(paintingsArr);

        int[] dp = new int[N];

        dp[0] = paintingsArr[0].cost;
        for (int i = 1; i < N; i++) {
            int maxHeightIdx = binarySearch(i);
            if(maxHeightIdx > -1) {
                //탐색 시
                dp[i] = Math.max(dp[maxHeightIdx] + paintingsArr[i].cost, dp[i - 1]);
            } else {
                //탐색하지 못하면
                dp[i] = Math.max(dp[i-1], paintingsArr[i].cost);
            }

        }

        System.out.println(dp[N - 1]);
    }

    static class Painting implements Comparable<Painting>{
        int height;
        int cost;

        public Painting(int height, int cost) {
            this.height = height;
            this.cost = cost;
        }

        @Override
        public int compareTo(Painting o) {
            return this.height - o.height;
        }
    }

    static int binarySearch(int curIdx){
        int mid = 0;
        int left = 0, right = curIdx;

        while(left <= right){
            mid = (left + right) / 2;
            int diff = paintingsArr[curIdx].height - paintingsArr[mid].height;
            if(diff >= S){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }

        return right;
    }
}
