import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long newScore = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // P는 1 이상 자연수이므로 리스트가 비었으면 무조건 1등
        if(N == 0){
            System.out.println(1);
            return;
        }

        long[] scores = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Long.parseLong(st.nextToken());
        }

        // 리스트가 차 있는데 현재 꼴지보다 작거나 같으면 자리 없음
        if(N == P){
            if(scores[N-1] >= newScore){
                System.out.println(-1);
                return;
            }
        }

        // 1등부터 시작
        int rank = 1;

        for (int i = 0; i < N; i++) {
            long curScore = scores[i];

            if(newScore < curScore){
                rank++;
            } else{
                break;
            }
        }

        if(rank > P) System.out.println(-1);
        else System.out.println(rank);
    }
}

