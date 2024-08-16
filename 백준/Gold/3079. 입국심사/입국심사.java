import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        ipts = br.readLine().split(" ");
        long N = Integer.parseInt(ipts[0]);
        long M = Integer.parseInt(ipts[1]);

        long[] booths = new long[(int)N];
        long min = Long.MAX_VALUE;
        long max = 0;

        for(int i = 0; i < N; i++){
            booths[i] = Long.parseLong(br.readLine());
            min = Math.min(min, booths[i]);
            max = Math.max(max, booths[i]);
        }

        long l = 0;
        long r = max * M;
        long ans = Long.MAX_VALUE;

        while(l <= r){
            long mid = (l + r) / 2;
            long total = 0;

            for(int i = 0; i < N; i++){
                if(total >= M){
                    break;
                }
                total += mid / booths[i];
            }

            if(total < M){
                l = mid + 1;
            } else{
                r = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        System.out.println(ans);
    }
}
