import java.io.*;
import java.util.*;

public class Main {
    static int N, M, houseCnt, storeCnt, chickenDist;
    static int[][] townMap;
    static ArrayList<int[]> houseList = new ArrayList<>();
    static ArrayList<int[]> storeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        M = Integer.parseInt(ipts[1]);
        houseCnt = 0;
        storeCnt = 0;
        chickenDist = Integer.MAX_VALUE;

        townMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                townMap[i][j] = Integer.parseInt(ipts[j]);
                if(townMap[i][j] == 1){
                    houseCnt++;
                    houseList.add(new int[] {i, j});
                } else if(townMap[i][j] == 2){
                    storeCnt++;
                    storeList.add(new int[] {i, j});
                }
            }
        }

        bt(0, new HashSet<>());
        System.out.println(chickenDist);
    }

    public static void bt(int start, HashSet<Integer> closeStore){
        // 폐업할 치킨집을 정했다면 치킨거리 계산 후 최소값 갱신
        if(closeStore.size() == storeCnt - M){
            int curDist = 0;
            for (int i = 0; i < houseList.size(); i++) {
                int curHouseStoreDist = Integer.MAX_VALUE;
                for (int j = 0; j < storeList.size(); j++) {
                    if(closeStore.contains(j)) continue;
                    curHouseStoreDist = Math.min( curHouseStoreDist, Math.abs(storeList.get(j)[0] - houseList.get(i)[0]) + Math.abs(storeList.get(j)[1] - houseList.get(i)[1]));
                }
                curDist += curHouseStoreDist;
            }

            chickenDist = Math.min(chickenDist, curDist);
            return;
        }

        // storeCnt - M개의 폐업 매장 선정하기
        for (int i = start; i < storeCnt; i++) {
            closeStore.add(i);
            bt(i+1, closeStore);
            closeStore.remove(i);
        }
    }
}