import java.io.*;
import java.util.Arrays;

public class Main {
    public static int bisect(int[] arrays, int target){
        int l = 0;
        int r = arrays.length-1;
        if(arrays[l] > target || arrays[r] < target){
            return -1;
        }

        int mid = 0;
        while(l <= r){
            mid = (r + l) / 2;
            if(arrays[mid] < target) {
                l = mid + 1;
            } else if(arrays[mid] > target){
                r = mid - 1;
            } else if(arrays[mid] == target){
                if(r == mid){
                    break;
                } else{
                    r = mid;
                }
            }
        }
        if(numbers[mid] == target)
            return mid;
        else
            return -1;
    }

    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipt = br.readLine().split(" ");
        int N = Integer.parseInt(ipt[0]);
        int M = Integer.parseInt(ipt[1]);
        numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        for(int i = 0; i < M-1; i++) {
            sb.append(bisect(numbers, Integer.parseInt(br.readLine())));
            sb.append("\n");
        }
        sb.append(bisect(numbers, Integer.parseInt(br.readLine())));
        sb.append("");
        bw.write(sb.toString());
        bw.flush();
    }
}
