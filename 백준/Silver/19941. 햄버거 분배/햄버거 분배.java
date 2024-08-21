import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;
        int l, r, answer;
        answer = 0;

        ipts = br.readLine().split( " ");
        int N = Integer.parseInt(ipts[0]);
        int K = Integer.parseInt(ipts[1]);

        char[] seats = br.readLine().toCharArray();
        boolean[] ate = new boolean[N];

        for(int i = 0; i < N; i++){
            if(seats[i] == 'P'){
                l = Math.max(0, i - K);
                r = Math.min(N-1, i + K);

                for(int j = l; j <= r; j++){
                    if(seats[j] == 'H' && !ate[j]){
                        answer++;
                        ate[j] = true;
                        break;
                    }
                }

            }
        }

        System.out.println(answer);
    }
}

// HHHHH PPPPP H P H P H P HHH P