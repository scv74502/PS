import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] ipts = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(ipts[i]);
        }

        lis = new int[N + 1];

        int lisLen = 0;
        int lisIdx = 0;

        for (int i = 0; i < N; i++) {
            if(numbers[i] > lis[lisLen]){
                lisLen++;
                lis[lisLen] = numbers[i];
            } else {
                lisIdx = binarySearch(0, lisLen, numbers[i]);
                lis[lisIdx] = numbers[i];
            }
        }

        System.out.println(lisLen);
    }

    public static int binarySearch(int left, int right, int target){
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;

            if(lis[mid] < target) left = mid + 1;
            else right = mid;
        }

        return right;
    }
}
