import java.io.*;
import java.util.*;

public class Main {
    static int[] moves = {-1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동생이 같은 위치나 더 뒤에 있으면 뒤로 가는 방법뿐
        if(N >= K){
            System.out.println(N - K + "\n1");
            return;
        }

        int[] spentTime = new int[100001];
//        spentTime[N] = 1;
        int minTime = 1000000;
        int count = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        while(!dq.isEmpty()){
            int now = dq.peek();
            dq.poll();

            if(minTime < spentTime[now]) continue;

            for (int i = 0; i < 3; i++) {
                int next;
                if(i < 2){
                    next = now + moves[i];
                } else{
                    next = now * 2;
                }

                if(next < 0 || 100_000 < next) continue;

                if(next == K) {
                    minTime = spentTime[now];
                    count++;
                }

                if(spentTime[next] == 0 || spentTime[next] == spentTime[now] + 1){
                    dq.add(next);
                    spentTime[next] = spentTime[now] + 1;
                }
            }
        }

        System.out.println(spentTime[K]);
        System.out.println(count);
    }
}


