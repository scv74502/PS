import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<int[]> checkPoints;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        checkPoints = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            checkPoints.add(new int[] {x, y});
        }

        int distanceSum = 0;
        for (int i = 0; i < N - 1; i++) {
            distanceSum += getDistance(checkPoints.get(i)[0], checkPoints.get(i)[1], checkPoints.get(i+1)[0], checkPoints.get(i+1)[1]);
        }

        int result = distanceSum;
        for (int i = 1; i < N - 1; i++) {
            int skippedDistance = distanceSum - getDistance(checkPoints.get(i-1)[0], checkPoints.get(i-1)[1], checkPoints.get(i)[0], checkPoints.get(i)[1])
                    - getDistance(checkPoints.get(i)[0], checkPoints.get(i)[1], checkPoints.get(i+1)[0], checkPoints.get(i+1)[1])
                    + getDistance(checkPoints.get(i-1)[0], checkPoints.get(i-1)[1], checkPoints.get(i+1)[0], checkPoints.get(i+1)[1]);

            result = Math.min(result, skippedDistance);
        }

        System.out.println(result);
    }


    static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
