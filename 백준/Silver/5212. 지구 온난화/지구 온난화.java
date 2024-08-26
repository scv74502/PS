import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipts;

        int R, C;
        ipts = br.readLine().split(" ");
        R = Integer.parseInt(ipts[0]);
        C = Integer.parseInt(ipts[1]);

        char[][] map = new char[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int minR = 10, maxR = 0;
        int minC = 10, maxC = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++) {
                if (map[i][j] == 'X'){
                    int cnt = 0;
                    for(int k = 0; k < 4; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if((x == -1 || y == -1 || x == R || y == C) || map[x][y] == '.'){
                            cnt++;
                        }
                    }

                    if(cnt < 3){
                        map[i][j] = 'X';

                        minR = Math.min(minR, i);
                        minC = Math.min(minC, j);
                        maxR = Math.max(maxR,i);
                        maxC = Math.max(maxC, j);
                    } else {
                        stack.push(new int[] {i, j});
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            map[cur[0]][cur[1]] = '.';
        }

        for(int i = minR; i <= maxR; i++){
            for(int j = minC; j <= maxC; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
