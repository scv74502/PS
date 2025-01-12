import java.io.*;

public class Main {
    static int[] arr;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;

        int N = Integer.parseInt(br.readLine());
        ipts = br.readLine().split(" ");
        arr = new int[N];
        lis = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ipts[i]);
        }

        // LIS의 가장 큰 값이 있는 위치, LIS의 현재 길이
        int lisIdx = 0;
        int lisLen = 0;

        for (int i = 0; i < N; i++) {
            // lis의 가장 큰 값이 현재 숫자보다 작으면 큰 값으로 갱신
            if(arr[i] > lis[lisLen]){
                lisLen++;
                lis[lisLen] = arr[i];
            } else{
                // lis의 기존 값들 중에서 갱신하기
                lisIdx = bisect(0, lisLen, arr[i]);
                lis[lisIdx] = arr[i];
            }
        }

        System.out.println(lisLen);
    }

    // lis 중에서 target보다 작거나 같은 상한선 위치 이분 탐색으로 탐색
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
