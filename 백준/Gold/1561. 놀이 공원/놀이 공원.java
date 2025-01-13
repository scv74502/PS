import java.io.*;

public class Main {
    static long N;
    static int M;
    static int[] attractions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        ipts = br.readLine().split(" ");
        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);

        ipts = br.readLine().split(" ");
        attractions = new int[M];
        for (int i = 0; i < M; i++) {
            attractions[i] = Integer.parseInt(ipts[i]);
        }

        long left = 0;
        long right = N * 30;

        // 놀이기구 시간이 최대 30분이므로 N * 30의 범위까지 탐색
        while(left < right){
            long mid = (left + right) / 2;
            // 현재 가능한 탑승인원이 N보다 작다면
            if(calcStudent(mid) < N){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        // 최소 시간을 구한 다음, 그 직전에 탑승한 학생의 수를 구함
        long lastStudent = calcStudent(right - 1);

        // 탑승한 N번째 아이를 구한 다음, 그 아이가 탄 놀이기구 번호를 출력
        for (int i = 0; i < M; i++) {
            if(right % attractions[i] == 0){
                lastStudent += 1;
            }
            if(lastStudent == N){
                System.out.println(i + 1);
                break;
            }
        }
    }

    // 특정 시간동안 탈 수 있는 아이들의 인원 수 구함
    public static long calcStudent(long time){
        // M개의 놀이기구아 있으므로 M명의 학생의 이용은 보장된다.
        long cnt = M;
        for (long attraction:attractions){
            // 놀이기구가 비면 바로 탑승
            cnt += Math.floorDiv(time, attraction);
        }
        return cnt;
    }
}

