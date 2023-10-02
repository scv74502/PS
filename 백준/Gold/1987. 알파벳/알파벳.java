import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {
	static int row;	// 행
	static int col;	// 렬
	static int[][] arr;	// 알파벳 지도
	static int[] dy = {-1, 1, 0, 0};	// 각각 상 하 담당
	static int[] dx = {0, 0, -1, 1};	// 각각 좌 우 담당
	static boolean[] visited;
	static int step = 1, max = 1;	// 임시로 세는 용도의 걸음 수와, 답으로 쓸 최대 걸음 수

	public static void main(String[] args) throws IOException {
		String[] s;
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		s = br.readLine().split(" ");
		row = Integer.parseInt(s[0]);
		col = Integer.parseInt(s[1]);
		arr = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			str = br.readLine();
			for(int j = 0; j < col; j++) {
				arr[i][j] = (int)str.charAt(j) - 'A';	// 정수 배열에 char 저장하기 위해 A를 빼면 알파벳 A가 0으로 저장됨
			}
		}
		visited = new boolean[26];
		dfs(0, 0);
		bw.write(max+"");
		bw.flush();
	}
	
	public static void dfs(int y, int x) {
		int start = arr[y][x];
		visited[start] = true;
		
		for(int i = 0; i < 4; i++) {
			int next_y = dy[i] + y;
			int next_x = dx[i] + x;
			
			if(next_x < 0 || next_y < 0 || next_x >= col || next_y >= row) {
				continue;
			}
			
			int next = arr[next_y][next_x];
			if(visited[next])
				continue;
			
			max = Math.max(max, ++step);
			
			dfs(next_y, next_x);
		}
		// 다른 경로에서의 접근을 위해서 초기화하기
		step--;
		visited[start] = false;
	}
}
