import java.io.*;

public class Main {
    static int answer, N;
    static int[] eggsHP;
    static int[] eggsWeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts;
        String ipt;

        N = Integer.parseInt(br.readLine());
        eggsHP = new int[N];
        eggsWeight = new int[N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            eggsHP[i] = Integer.parseInt(ipts[0]);
            eggsWeight[i] = Integer.parseInt(ipts[1]);
        }

        bt(0, 0);
        System.out.println(answer);
    }

    public static void bt(int curEggIdx, int brokenEggs){
        // 맨 오른쪽 계란까지 들었으면 넘어간다
        if(curEggIdx == N){
            answer = Math.max(answer, brokenEggs);
            return;
        }

        // 집은 계란이 깨졌으면 치지 않고 넘어간다
        if(eggsHP[curEggIdx] <= 0){
            bt(curEggIdx + 1, brokenEggs);
        } else{
            for (int i = 0; i < N; i++) {
                // 자기자신은 자기가 깰 수 없다
                if(i == curEggIdx) continue;

                else if(brokenEggs == N-1) bt(curEggIdx+1, brokenEggs);

                // 치려는 계란들이 깨지지 않았으면
                else if(eggsHP[i] > 0) {
                    // 계란을 부딪히면 상대 계란의 무게만큼 내구도가 감소한다
                    eggsHP[curEggIdx] -= eggsWeight[i];
                    eggsHP[i] -= eggsWeight[curEggIdx];

                    int curBrokenEggs = brokenEggs;
                    if(eggsHP[curEggIdx] <= 0) curBrokenEggs++;
                    if(eggsHP[i] <= 0) curBrokenEggs++;
                    // 오른쪽 계란을 집어서 다음 순서 진행하기
                    bt(curEggIdx + 1, curBrokenEggs);

                    // 계란을 서로 부딪히기 전으로 상태 복구하기
                    eggsHP[curEggIdx] += eggsWeight[i];
                    eggsHP[i] += eggsWeight[curEggIdx];
                }
            }
        }
    }

}
