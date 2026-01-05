import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] blanks;
    static int[][] seats;
    static HashSet<Integer>[] preferFriend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        seats = new int[N][N];
        blanks = new int[N][N]; // 초기화 추가
        preferFriend = new HashSet[N * N + 1]; // 학생 번호는 N*N까지 가능하므로 크기 수정

        // 선호하는 친구들 입력받기 전 HashSet 초기화
        for(int i=1; i<=N*N; i++) {
            preferFriend[i] = new HashSet<>();
        }

        // 공백 수 초기 마킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
                    blanks[i][j]++; // 인접한 칸이 범위 내에 있으면 빈 칸으로 간주 (초기 상태)
                }
            }
        }

        // 선호하는 친구들 입력받기
        for (int i = 0; i < N * N; i++) {
            String[] ipts = br.readLine().split(" ");
            int studentNum = Integer.parseInt(ipts[0]);
            for (int j = 1; j < 5; j++) {
                preferFriend[studentNum].add(Integer.parseInt(ipts[j]));
            }

            // 제일 적합한 자리 찾아서 앉기 처리
            findProperSeat(studentNum);
        }

        int satisFactorySum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                satisFactorySum += calcSatisfactory(i, j);
            }
        }

        System.out.println(satisFactorySum);
    }

    public static int countPreferFriend(int r, int c, int studentNum){
        int answer = 0;

        // 친구 수 세기
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
            if(preferFriend[studentNum].contains(seats[nr][nc])) answer++; // seats[i][j] -> seats[nr][nc] 수정
        }

        return answer;
    }

    // 자리에 학생이 앉고 나서 주변 칸의 공백 갱신
    public static void renewBlank(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || N <= nr || nc < 0 || N <= nc) continue;
            if (blanks[nr][nc] > 0) blanks[nr][nc]--;
        }
    }

    public static void findProperSeat(int studentNum){
        // 좋아하는 학생이 가장 많은칸, 비어있는 칸이 가장 많은칸, 행의 번호가 가장 작은칸, 열의 번호가 가장 작은칸 순
        SeatInfo bestSeat = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (seats[i][j] != 0) continue; // 이미 앉은 자리는 패스

                int friendCount = countPreferFriend(i, j, studentNum);
                int emptyCount = blanks[i][j]; // 미리 계산된 공백 수 사용

                SeatInfo currentSeat = new SeatInfo(friendCount, emptyCount, i, j);
                
                if (bestSeat == null || currentSeat.compareTo(bestSeat) < 0) {
                    bestSeat = currentSeat;
                }
            }
        }

        if (bestSeat != null) {
            seats[bestSeat.r][bestSeat.c] = studentNum;
            renewBlank(bestSeat.r, bestSeat.c);
        }
    }

    public static class SeatInfo implements Comparable<SeatInfo> {
        int preferFriendAmount;
        int nearEmptySeat;
        int r;
        int c;

        public SeatInfo(int preferFriendAmount, int nearEmptySeat, int r, int c) {
            this.preferFriendAmount = preferFriendAmount;
            this.nearEmptySeat = nearEmptySeat;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(SeatInfo o) {
            if (this.preferFriendAmount != o.preferFriendAmount) {
                return o.preferFriendAmount - this.preferFriendAmount; // 내림차순
            }
            if (this.nearEmptySeat != o.nearEmptySeat) {
                return o.nearEmptySeat - this.nearEmptySeat; // 내림차순
            }
            if (this.r != o.r) {
                return this.r - o.r; // 오름차순
            }
            return this.c - o.c; // 오름차순
        }
    }

    public static int calcSatisfactory(int r, int c){
        int satisfactory = 10;
        int preferFriendAmount = countPreferFriend(r, c, seats[r][c]);

        if(preferFriendAmount == 0) return 0;

        return (int)Math.pow(satisfactory, preferFriendAmount - 1);
    }
}
