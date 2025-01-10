import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        int N = Integer.parseInt(ipts[0]);
        int M = Integer.parseInt(ipts[1]);
        int L = Integer.parseInt(ipts[2]);

        ipts = br.readLine().split(" ");
        ArrayList<Integer> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            points.add(Integer.parseInt(ipts[i]));
        }

        points.add(0);
        points.add(L);

        Collections.sort(points);

        int left = 1, right = L;

        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < points.size(); i++) {
                count += (points.get(i) - points.get(i-1) - 1) / mid;
            }

            if(count > M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }
}
