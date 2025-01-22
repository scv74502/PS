import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[] {0, -1, 0, 1};
    static int[] dc = new int[] {1, 0, -1, 0};
    static int[][] arr = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        StringBuilder sb = new StringBuilder();
        ArrayList<int[]> list = new ArrayList<>();
        int ans = 0;

        int sc, sr, dir, g;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.clear();
            ipts = br.readLine().split(" ");
            sc = Integer.parseInt(ipts[0]);
            sr = Integer.parseInt(ipts[1]);
            dir = Integer.parseInt(ipts[2]);
            g = Integer.parseInt(ipts[3]);
            list.add(new int[] {sr, sc});
            list.add(new int[] {sr + dr[dir], sc + dc[dir]});
            for (int j = 0; j < g; j++) {
                int[] end = list.get(list.size() - 1);
                int er = end[0];
                int ec = end[1];
                for (int k = list.size() - 2; k >=0 ; k--) {
                    int[] cur = list.get(k);
                    int cr = cur[0];
                    int cc = cur[1];
                    list.add(new int[] {er - (ec - cc), ec + (er - cr)});
                }
            }

            for(int[] cur:list){
                arr[cur[0]][cur[1]] = 1;
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i+1][j+1]
                        && arr[i][j] == 1){
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}

