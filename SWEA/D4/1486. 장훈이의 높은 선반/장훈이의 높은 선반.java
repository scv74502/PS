import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] cards; // 부분집합의 재료.
	static int N, B, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			ans = Integer.MAX_VALUE;

			cards = new int[N];
			for (int i = 0; i < N; i++) { // 직원들의 키
				cards[i] = sc.nextInt();
			}

			subset(); // 재료 번호.

			System.out.println("#" + tc + " " + (ans - B));
		}
	}

	private static void subset() {
		for (int i = 0; i < (1 << N); i++) { // 부분집합의 번호 i (ex: N이 3일때는 0~7까지 번호 붙이고)
			int sum = 0; // i번 부분집합 출발!
			for (int j = 0; j < N; j++) { // j번 원소를 넣을지 뺄지
				if ((i & (1 << j)) > 0) { // j를 ++하면서 1을 옆으로 한칸씩 밀어본다. 
					sum += cards[j];
				}
			}
			if(sum>=B && sum<ans)
				ans = sum;
		}
	}
}
