import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D, W, K; // 레이어숫자, 가로크기, 검사 적합 기준
	static int[][] origin;
	static int ans; 
	
	static int[] layer0, layer1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();

			origin = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					origin[i][j] = sc.nextInt();
				}
			} // 기존 필름 상태
			
			ans = Integer.MAX_VALUE;
			layer0 = new int[W];
			layer1 = new int[W];
			
			Arrays.fill(layer0, 0);
			Arrays.fill(layer1, 1);
			for(int r=0; r<=D; r++) { // 약품 투입수 조절. 점차 늘려감.
				comb(0, 0, r); // 레이어번호, 약품투입 레이어, 투입 제한
				if(ans<Integer.MAX_VALUE)
					break;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void comb(int idx, int cnt, int r) { // idx는 레이어 번호, 약품주입 갯수
		if(cnt==r) { // 약품 시나리오 하나 완성됨! 시뮬레이션 해보자!
			if(check(origin)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		if(idx == D) return;

		comb(idx+1, cnt, r); // 현재 레이어에 약품주입 안함. cnt 그대로 유지.
		
		int[] now = origin[idx]; // 현재 레이어 임시보관
		
		origin[idx] = layer0; // 약품A 레이어 주입
		comb(idx+1, cnt+1, r);
		origin[idx] = layer1; // 약품B 레이어 주입
		comb(idx+1, cnt+1, r);
		
		origin[idx] = now; // 약품 시뮬레이션 돌려봤으면 원상복구 해놓고 종료.
	}
	
	static int[][] deepcopy(int[][] arr){
		int[][] copy = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}
	
	static boolean check(int[][] arr) {
		for(int j=0; j<W; j++) {
			int cnt=1;
			for(int i=1; i<D; i++) {
				if(arr[i-1][j]==arr[i][j]) // 내 윗행이랑 약품 같으면? 갯수 기록
					cnt++;
				else
					cnt=1;
				
				if(cnt==K)
					break;
			}
			if(cnt<K)
				return false;
		}
		return true;
	}
}








