import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] origin, copy; // 처음 소용돌이 위치 기억하는 원본, 소용돌이 줄어드는 카피
	
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			
			origin = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					origin[i][j] = sc.nextInt();
					origin[i][j] = origin[i][j]==1? -1:origin[i][j]; // 장애물은 -1로 구분하기. 
				}
			}
			
			int ans = bfs(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt()));
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static int bfs(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		
		queue.add(start);
		visit[start.i][start.j] = true;
		
		int time=0;
		while(!queue.isEmpty()) {
			if(time%3==0) // 2-1-0 한다음 바로 소용돌이 다시 생기는 처리.
				copy = deepcopy(origin);
			
			int size = queue.size();
			for(int s=0; s<size; s++) {
				Point now = queue.poll();
				
				if(now.i == end.i && now.j == end.j)
					return time;
				
				for(int d=0; d<4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];
					
					if(nexti<0 || nexti>=N || nextj<0 || nextj>=N || copy[nexti][nextj]==-1 || visit[nexti][nextj]) 
						continue; // 못가는 칸으로는 복제인간 안만듬.
					
					if(copy[nexti][nextj]==0) {
						queue.add(new Point(nexti, nextj));
						visit[nexti][nextj] = true;
					}
					
					if(copy[nexti][nextj]>0) { // 현재칸 now 옆칸이 소용돌이네?
						queue.add(now); // 원래 나는 사라질 예정이었는데.. 여기 한번더 머물러보자..
					}
				}
			}
			time++; // 1초 흐른뒤
			for(int i=0; i<N; i++){ // 모든 소용돌이들이 잦아든다.
				for(int j=0; j<N; j++) {
					copy[i][j] = copy[i][j]>0? copy[i][j]-1:copy[i][j];
				}
			}
		}
		
		return -1;
	}

	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] deepcopy(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}







