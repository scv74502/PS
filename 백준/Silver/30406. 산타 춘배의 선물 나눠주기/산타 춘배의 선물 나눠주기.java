import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        ipts = br.readLine().split(" ");
        int[] cnt = new int[4];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(ipts[i]);
            cnt[numbers[i]]++;
        }

        int score = 0;

        while(cnt[0] > 0 && cnt[3] > 0){
            cnt[0]--;
            cnt[3]--;
            score += 0 ^ 3;
        }

        int firstLeft, secondLeft;

        if(cnt[0] == 0){
            firstLeft = 3;
        } else{
            firstLeft = 0;
        }

        while(cnt[1] > 0 && cnt[2] > 0){
            cnt[1]--;
            cnt[2]--;
            score += 1 ^ 2;
        }

        if(cnt[1] == 0){
            secondLeft = 2;
        } else{
            secondLeft = 1;
        }

        while(cnt[firstLeft] > 0 && cnt[secondLeft] > 0){
            cnt[firstLeft]--;
            cnt[secondLeft]--;
            score += firstLeft ^ secondLeft;
        }

        System.out.println(score);
    }
}
