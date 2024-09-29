import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        ipt = br.readLine();
        int N = Integer.parseInt(ipt);

        char[][] pixels = new char[N+1][N+1];
        for(int i = 1; i <= N; i++){
            ipt = br.readLine();
            for(int j = 1; j <= N; j++){
                pixels[i][j] = ipt.charAt(j - 1);
            }
        }

//        System.out.println(Arrays.deepToString(pixels));

        int heartX = 0;
        int heartY = 0;
        for(int i = 2; i < N; i++){
            for(int j = 1; j < N; j++){
                if(pixels[i-1][j] == '*' && pixels[i][j-1] == '*' && pixels[i+1][j] == '*' && pixels[i][j+1] == '*'){
                    heartX = i;
                    heartY = j;
                    break;
                }
            }
        }

        System.out.println(heartX + " " + heartY);

        // 1. 왼팔
        int leftArm = 0;
        for(int i = heartY-1; i > 0; i--){
            if(pixels[heartX][i] != '*'){
                break;
            }
            leftArm++;
        }
        // 2. 오른팔
        int rightArm = 0;
        for(int i = heartY+1; i <= N; i++){
            if(pixels[heartX][i] != '*'){
                break;
            }
            rightArm++;
        }

        // 3. 허리
        int back = 0;
        for(int i = heartX+1; i <= N; i++){
            if(pixels[i][heartY] != '*'){
                break;
            }
            back++;
        }

        // 4. 왼다리
        int leftLeg = 0;
        for(int i = heartX + back + 1; i <= N; i++){
            if(pixels[i][heartY-1] != '*'){
                break;
            }
            leftLeg++;
        }

        // 5. 오른다리
        int rightLeg = 0;
        for(int i = heartX + back + 1; i <= N; i++){
            if(pixels[i][heartY+1] != '*'){
                break;
            }
            rightLeg++;
        }

        System.out.println(leftArm + " " + rightArm + " " + back + " " + leftLeg + " " + rightLeg);
    }
}