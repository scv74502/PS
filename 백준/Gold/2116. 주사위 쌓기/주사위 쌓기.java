import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] dices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;
        answer = -1;

        N = Integer.parseInt(br.readLine());
        dices = new int[N][6];

        for(int i = 0; i < N; i++){
            ipts = br.readLine().split(" ");
            for(int j = 0; j < 6; j++){
                dices[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        for(int i = 0; i < 6; i++){
            search(1, i, 0);
        }

        System.out.println(answer);
    }

    static void search(int row, int bottom, int sum){
        int top = getPair(bottom);
        int tmpMax = -1;
        for(int i = 0; i < 6; i++){
            if(i == top || i == bottom){
                continue;
            }
            tmpMax = Math.max(tmpMax, dices[row-1][i]);
        }
        sum += tmpMax;
        if(row == N){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 6; i++){
            if(dices[row-1][top] == dices[row][i]){
                search(row+1, i, sum);
                break;
            }
        }
    }

    static int getPair(int eye){
        if(eye == 0){
            return 5;
        } else if (eye == 1) {
            return 3;
        } else if (eye == 2) {
            return 4;
        } else if (eye == 3) {
            return 1;
        } else if (eye == 4) {
            return 2;
        } else {
            return 0;
        }
    }
}
