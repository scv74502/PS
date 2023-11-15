import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, s, b;	// 재료의 개수, 신맛과 쓴맛
	static int[][] arr;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String[] s;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];	// n번째 재료의 신맛과 쓴맛을 기억한다
		for(int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		solution(0, 1, 0, 0);
		bw.write(ans+"\n");
		bw.flush();
		
	}
	
	private static void solution(int cnt, int sour, int bitter, int c) {
		if(cnt == n) {
			if(ans > (sour > bitter ? sour-bitter : bitter-sour) && c != 0) {
				ans = (sour > bitter ? sour-bitter : bitter-sour);
			}
			return;
		}
		solution(cnt+1, sour * arr[cnt][0], bitter + arr[cnt][1], c+1);
		solution(cnt+1, sour, bitter, c);
	}
}