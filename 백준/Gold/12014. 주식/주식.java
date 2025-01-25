import java.io.*;

public class Main {
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int rpt = Integer.parseInt(br.readLine());

        for (int i = 1; i <= rpt; i++) {
            ipts = br.readLine().split(" ");
            int N = Integer.parseInt(ipts[0]);
            int K = Integer.parseInt(ipts[1]);
            arr = new int[N];
            lis = new int[N + 1];

            ipts = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(ipts[j]);
            }

            // LIS의 가장 큰 값이 있는 위치, LIS의 현재 길이
            int lisIdx = 0;
            int lisLen = 0;

            for (int j = 0; j < N; j++) {
                // lis의 가장 큰 값이 현재 숫자보다 작으면 큰 값으로 갱신
                if(arr[j] > lis[lisLen]){
                    lisLen++;
                    lis[lisLen] = arr[j];
                } else{
                    // lis의 기존 값들 중에서 갱신하기
                    lisIdx = bisect(0, lisLen, arr[j]);
                    lis[lisIdx] = arr[j];
                }
            }

            sb.append("Case #").append(i).append("\n");
            sb.append(lisLen >= K ? 1 : 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // lis 중에서 target보다 작거나 같은 하한선 위치 이분 탐색으로 탐색
    public static int bisect(int left, int right, int target){
        int mid;

        while(left < right){
            mid = (left + right) / 2;

            if(lis[mid] < target) left = mid + 1;
            else right = mid;
        }

        return right;
    }
}
