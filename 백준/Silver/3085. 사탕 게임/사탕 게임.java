import java.io.*;

public class Main {
    static int N;
    public static char[][] candies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        candies = new char[N][N];

        for (int i = 0; i < N; i++) {
            String ipt = br.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = ipt.charAt(j);
            }
        }

        int answer = 0;

        // 가로로 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if(candies[i][j] != candies[i][j + 1]){
                    swap(i, j, i, j+1);
                    answer = Math.max(answer, maxSeq());
                    swap(i, j, i, j+1);
                    if(answer == N){
                        System.out.println(N);
                        return;
                    }
                }
            }
        }

        // 세로로 체크
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N; j++) {
                if(candies[i][j] != candies[i+1][j]){
                    swap(i, j, i+1, j);
                    answer = Math.max(answer, maxSeq());
                    swap(i, j, i+1, j);
                    if(answer == N){
                        System.out.println(N);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void swap(int cr, int cc, int nr, int nc){
        char temp = candies[cr][cc];
        candies[cr][cc] = candies[nr][nc] ;
        candies[nr][nc] = temp;
    }

    public static int maxSeq(){
        int answer = -1;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            char curChar = candies[i][0];
            for (int j = 1; j < N; j++) {
                if(curChar == candies[i][j]) cnt++;
                else{
                    answer = Math.max(answer, cnt);
                    cnt = 1;
                }
                curChar = candies[i][j];
            }

            answer = Math.max(answer, cnt);
            cnt = 1;
            curChar = candies[0][i];

            for (int j = 1; j < N; j++) {
                if(curChar == candies[j][i]) cnt++;
                else{
                    answer = Math.max(answer, cnt);
                    cnt = 1;
                }
                curChar = candies[j][i];
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
