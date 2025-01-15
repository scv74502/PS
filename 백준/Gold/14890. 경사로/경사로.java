import java.io.*;
import java.util.*;

public class Main {
    static int N, L, answer = 0;
    static boolean[] isSetup;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipts = br.readLine().split(" ");

        N = Integer.parseInt(ipts[0]);
        L = Integer.parseInt(ipts[1]);

        isSetup = new boolean[N];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(ipts[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            if(checkRow(i)) answer++;
            if(checkCol(i)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean checkRow(int rowNum){
        Arrays.fill(isSetup, false);

        for (int i = 0; i < N-1; i++) {
            int heightDiff = board[rowNum][i] - board[rowNum][i+1];
            // 높이차이가 1 이상이면 불가하다
            if(Math.abs(heightDiff) > 1) return false;

            // 다음 계단이 한 계단 높다면 지금 계단 ~ 지금-L번째 계단까지 탐색하여 경사로를 높는다
            else if(heightDiff == -1){
                // i부터 j까지 경사로를 위한 탐색
                for (int j = 0; j < L; j++) {
                    // 범위를 초과하거나 이미 경사가 설치되었다면 설치 불가 -> 이동 불가
                    if(i - j < 0 || isSetup[i - j]) return false;
                    // 원래 지역과 높이가 같지 않으면 경사로 설치 불가함
                    if(board[rowNum][i]  != board[rowNum][i - j]) return false;
                    // 경사로 설치
                    isSetup[i - j] = true;
                }
            }

            // 다음 계단이 한 계단 낮다면
            else if(heightDiff == 1){
                // i부터 j까지 경사로를 위한 탐색
                for (int j = 1; j <= L; j++) {
                    // 범위를 초과하거나 이미 경사가 설치되었다면 설치 불가 -> 이동 불가
                    if(i + j >= N || isSetup[i + j]) return false;
                    // 원래 지역보다 한계단 낮지 않으면 경사로 설치 불가함
                    if(board[rowNum][i] - 1 != board[rowNum][i + j]) return false;
                    // 경사로 설치
                    isSetup[i + j] = true;
                }
            }
        }

        return true;
    }

    public static boolean checkCol(int colNum){
        Arrays.fill(isSetup, false);

        for (int i = 0; i < N-1; i++) {
            int heightDiff = board[i][colNum] - board[i+1][colNum];
            // 높이차이가 1 이상이면 불가하다
            if(heightDiff > 1 || heightDiff < -1) return false;

            // 다음 계단이 한 계단 높다면 지금 계단 ~ 지금-L번째 계단까지 탐색하여 경사로를 높는다
            else if(heightDiff == -1){
                // i부터 j까지 경사로를 위한 탐색
                for (int j = 0; j < L; j++) {
                    // 범위를 초과하거나 이미 경사가 설치되었다면 설치 불가 -> 이동 불가
                    if(i - j < 0 || isSetup[i - j]) return false;
                    // 원래 지역과 높이가 같지 않으면 경사로 설치 불가함
                    if(board[i][colNum]  != board[i - j][colNum]) return false;
                    // 경사로 설치
                    isSetup[i - j] = true;
                }
            }

            // 다음 계단이 한 계단 낮다면
            else if(heightDiff == 1){
                // i부터 j까지 경사로를 위한 탐색
                for (int j = 1; j <= L; j++) {
                    // 범위를 초과하거나 이미 경사가 설치되었다면 설치 불가 -> 이동 불가
                    if(i + j >= N || isSetup[i + j]) return false;
                    // 원래 지역보다 한계단 낮지 않으면 경사로 설치 불가함
                    if(board[i][colNum] - 1 != board[i + j][colNum]) return false;
                    // 경사로 설치
                    isSetup[i + j] = true;
                }
            }
        }
        return true;
    }

}