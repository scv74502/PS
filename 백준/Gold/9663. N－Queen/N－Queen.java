import java.io.*;

public class Main {
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        // col[N]은 N번열에 위치한 퀸의 행 값
        int[] col = new int[N];
        bt(0, col);

        System.out.println(answer);
        br.close();
        bw.close();
    }

    public static void bt(int curRow, int[] col){
        // 모든 열에 퀸 하나씩 있으면 방법 증가
        if(curRow == N){
            answer++;
            return;
        }

        // 0부터 i열까지 놓을 수 있는 열을 체크
        // 0부터 curRow행까지 현재 i열에 퀸이 없어야 함(이전퀸 행 != 현재퀸 행,세로이동)
        // 0부터 curRow행까지 퀸이 대각선에 겹치지 말아야 함 - ((이전퀸 열 - 현재퀸 열)의 절대값 != (이전퀸 행 - 현재퀸 행)의 절대값,대각선이동)
        for(int i = 0; i < N; i++){
            boolean isAvailable = true;
            for (int j = 0; j < curRow; j++) {
                if(!locCheck(curRow, i, j, col[j])){
                    isAvailable = false;
                    break;
                }
            }

            if(isAvailable){
                col[curRow] = i;
                bt(curRow + 1, col);
                col[curRow] = 0;
            }
        }
    }

    public static boolean locCheck(int curRow, int curCol, int tgtRow, int tgtCol){
        if(curCol == tgtCol || Math.abs(curCol - tgtCol) == Math.abs(curRow - tgtRow)){
            return false;
        }
        return true;
    }
}
