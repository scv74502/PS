import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static ArrayList<Integer> lightLocs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lightLocs = new ArrayList<>();

//        lightLocs.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int loc = Integer.parseInt(st.nextToken());
            lightLocs.add(loc);
        }
//        lightLocs.add(N);

        int answer = findMinHeight();
        System.out.println(answer);
    }

    public static int findMinHeight(){
        int l = 0;
        int r = N;
        int result = 0;

        while (l <= r){
            int mid = (l + r) / 2;
            if(isAllLighten(mid)){
                r = mid - 1;
                result = mid;
            } else{
                l = mid + 1;
            }
        }

        return result;
    }

    public static boolean isAllLighten(int height){
        if(lightLocs.get(0) > height){
            return false;
        }

        if(lightLocs.get(lightLocs.size() - 1) + height < N){
            return false;
        }

        for (int i = 0; i < lightLocs.size() - 1; i++) {
            int leftLight = lightLocs.get(i);
            int rightLight = lightLocs.get(i + 1);
            if(leftLight + height < rightLight - height){
                return false;
            }
        }
        return true;
    }
}
