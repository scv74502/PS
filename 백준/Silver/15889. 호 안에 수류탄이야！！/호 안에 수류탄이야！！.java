import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
            return;
        }
        
        int[] soldiers = new int[N];
        int[] ranges = new int[N - 1];

        ipts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            soldiers[i] = Integer.parseInt(ipts[i]);
        }

        ipts = br.readLine().split(" ");
        for (int i = 0; i < N-1; i++) {
            ranges[i] = Integer.parseInt(ipts[i]);
        }

        boolean[] reachable = new boolean[N];
        reachable[0] = true;

        for (int i = 0; i < N-1; i++) {
            if(!reachable[i]) continue;
            int reach = soldiers[i] + ranges[i];
            for (int j = i+1; j < N; j++) {
                if(soldiers[j] <= reach) reachable[j] = true;
            }

            if(reachable[N-1]){
                System.out.println("권병장님, 중대장님이 찾으십니다");
                return;
            }
        }

        if(reachable[N-1]){
            System.out.println("권병장님, 중대장님이 찾으십니다");
        } else{
            System.out.println("엄마 나 전역 늦어질 것 같아");
        }
    }
}
