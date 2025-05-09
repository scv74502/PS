import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] liquids;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solution();
    }

    static void solution(){
        int left = 0;
        int right = N-1;
        int answer = Math.abs(liquids[left] + liquids[right]);
        int resultLeft = left;
        int resultRight = right;

        while(left < right){
            int sum = liquids[left] + liquids[right];
            if(Math.abs(sum) < answer){
                answer = Math.abs(sum);
                resultLeft = left;
                resultRight = right;

                if(answer == 0) break;
            }

            if(sum < 0){
                left++;
            } else{
                right--;
            }
        }

        System.out.println(liquids[resultLeft] + " " + liquids[resultRight]);
    }
}
