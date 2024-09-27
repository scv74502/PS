import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int N, K;
        ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        K = Integer.parseInt(ipts[1]);

        int[][] records = new int[N][4];

        for(int i = 0; i < N; i++){
            ipts = br.readLine().split(" ");
            records[i][0] = Integer.parseInt(ipts[0]);
            records[i][1] = Integer.parseInt(ipts[1]);
            records[i][2] = Integer.parseInt(ipts[2]);
            records[i][3] = Integer.parseInt(ipts[3]);
        }

        Arrays.sort(records, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] != o2[1]){
                    return o2[1] - o1[1];
                }

                if(o1[2] != o2[2]){
                    return o2[2] - o1[2];
                }

                return o2[3] - o1[3];
            }
        });

//        System.out.println(Arrays.deepToString(records));
        int[] ranks = new int[N+1];

        ranks[records[0][0]] = 1;
        int curRank = 1;
        int sameRankers = 1;

        for(int i = 1; i < N; i++){
            if(isSame(records[i-1], records[i])){
                ranks[records[i][0]] = curRank;
                sameRankers += 1;
            } else{
                curRank += sameRankers;
                ranks[records[i][0]] = curRank;
                sameRankers = 1;
            }
        }

        System.out.println(ranks[K]);
    }

    static boolean isSame(int[] o1, int[] o2){
        return o1[1] == o2[1] && o1[2] == o2[2] && o1[3] == o2[3];
    }
}