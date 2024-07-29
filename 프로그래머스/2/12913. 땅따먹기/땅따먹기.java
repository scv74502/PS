import java.util.*;


class Movement{
    int row;
    int column;
    int score;

    public Movement(int row, int column, int score){
        this.row = row;
        this.column = column;
        this.score = score;
    }

    @Override
    public String toString(){
        return "row : " + row + ", column : " + column + ", score : " + score;
    }
}

class Solution {
    // 같은 열을 연속하여 밟을 수 없음, 열이 4개로 고정됨
    // 가로 4인 대각 좌우, 가로 3인 대각 좌우, 가로 2인 대각 좌우
    public static int[] mvC = new int[] {-3, 3, -2, 2, -1, 1};

    static int solution(int[][] land) {
        int R = land.length;
        int C = land[0].length;
        int answer = 0;
        Movement cur, nCur;
        int nr, nc, nSc, cntR;
        cntR = 1;
        nSc = 0;

        // 점수 저장하는 보드 만듦
        int[][] scoreBoard = new int[R][C];

        Deque<Movement> dq = new ArrayDeque<>();

        // 0번 행의 4개 열을 모두 덱에 삽입
        for(int i = 0; i < 4; i++){
            dq.add(new Movement(0, i, land[0][i]));
        }

        while(!dq.isEmpty()){
            while(!dq.isEmpty()) {
                cur = dq.poll();
                //System.out.println(cur);
                // 마지막 라인에 도달하면 현재 점수와 비교하여 큰 값을 취함(최대점수가 목적)
                if (cur.row == R) {
                    continue;
                }

                // 그 외에는 순회하며 벗어나지 않았는지 체크하고 점수 합산하여 덱에 넣음(스코어보드)
                for (int i = 0; i < 6; i++) {
                    nr = cur.row + 1;
                    nc = cur.column + mvC[i];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                        nSc = cur.score + land[nr][nc];
                        // 스코어보드보다 높은 점수의 탐색만 계속 진행하여 탐색 횟수 줄임
                        if (nSc > scoreBoard[nr][nc]) {
                            //dq.add(new Movement(nr, nc, nSc));
                            scoreBoard[nr][nc] = nSc;
                        }
                    }
                }
            }

            if(cntR < R-1) {
                // 0번 행의 4개 열을 모두 덱에 삽입
                for (int i = 0; i < 4; i++) {
                    dq.add(new Movement(cntR, i, scoreBoard[cntR][i] ));
                }
            }
            cntR++;
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, scoreBoard[R-1][i]);
        }

        return answer;
    }
}