import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int N, M, K; // map size, virus count
	static ArrayList<Virus> virusList;
	static int[] di = { 0, -1, +1, 0, 0 };
	static int[] dj = { 0, 0, 0, -1, +1 };
	static final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt(); // map size
			M = sc.nextInt(); // time
			K = sc.nextInt(); // virus cnt

			virusList = new ArrayList<Virus>();
			for (int k = 0; k < K; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int cnt = sc.nextInt();
				int dir = sc.nextInt();
				virusList.add(new Virus(i, j, cnt, dir));
			}
			
			for(int time=0; time<M; time++) {
				// 일단 합치지 말고 모두 이동해!!
				for(int i=0; i<virusList.size(); i++) {
					Virus now = virusList.get(i); 
					now.i = now.i + di[now.dir];
					now.j = now.j + dj[now.dir];
					now.num = now.i*N + now.j; // 바이러스 이동 완료!
					
					// 이동한곳이 약품이면? 거기서는 충돌은 없음. 그냥 반감!
					if(now.i==0 || now.i==N-1 || now.j==0 || now.j==N-1) {
						now.size /= 2; // 사이즈 감소
						now.dir = reverse(now.dir); // 방향 반대
						if(now.size==0) { // 군집 소멸.
							virusList.remove(i);
							i--; // 방금 삭제로 인덱스 뒤에 놈이 땡겨지니까 봐줘야함.
						}
					}
				}// 모든 애들 이동 완료!
				
				Collections.sort(virusList); // 칸번호로 줄서!
				for(int i=0; i<virusList.size()-1; i++) {
					Virus now = virusList.get(i);
					Virus next= virusList.get(i+1);
					if(now.num == next.num) { // 같은칸! 충돌!
						now.size += next.size; // 앞에가 더 군집이 큼!
						virusList.remove(i+1);
						i--;
					}
				}
			} // end time;
			
			int ans = 0;
			for(Virus v: virusList) {
				ans += v.size;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	static int reverse(int dir) {
		switch (dir) {
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		case LEFT:
			return RIGHT;
		case RIGHT:
			return LEFT;
		}
		return -1;
	}

	static class Virus implements Comparable<Virus> {
		int num;
		int i, j;
		int size, dir;

		Virus(int i, int j, int size, int dir) {
			this.i = i;
			this.j = j;
			this.size = size;
			this.dir = dir;
			num = i * N + j;
		}

		@Override
		public int compareTo(Virus o) {
			if (this.num == o.num) // 같은칸에 있는 바이러스! 충돌이네 ?!
				return o.size - this.size; // 군집 크기로 내림차순
			return this.num - o.num; // 칸번호로 정렬
		}
	}
}
