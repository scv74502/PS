import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        while(true){
            ipts = br.readLine().split(" ");
            int N = Integer.parseInt(ipts[0]);
            int M = (int)(Double.parseDouble(ipts[1]) * 100 + 0.5);

            if(N == 0 && M == 0) return;

            int[] calorieInfo= new int[N];
            int[] priceInfo = new int[N];

            for (int i = 0; i < N; i++) {
                ipts = br.readLine().split(" ");
                int calorie = Integer.parseInt(ipts[0]);
                int price = (int)(Double.parseDouble(ipts[1]) * 100 + 0.5);
                calorieInfo[i] = calorie;
                priceInfo[i] = price;
            }

            int[] dp = new int[M + 1];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                int calorie = calorieInfo[i];
                int price = priceInfo[i];

                for (int j = price; j <= M; j++) {
                    dp[j] = Math.max(dp[j], dp[j-price] + calorie);
                    answer = Math.max(dp[j], answer);
                }
            }

            System.out.println(answer);
        }
    }
}
