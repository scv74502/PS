import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
	static int arr[];
	static int n, k;
	static ArrayDeque<Integer> q = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {
		String[] s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		
		if(n >= k) {
			bw.write((n-k) + "");
			bw.flush();
		} else {
			bw.write(bfs()+"");
			bw.flush();
		}
	}
	
	static int bfs() {
		arr = new int[100001];	// 시간 저장하는 배열
		q.offer(n);
		arr[n] = 1;
		while(q.isEmpty() == false) {
			int num = q.poll();
			for(int i = 0; i < 3; i++) {
				int next = 0;
				switch(i) {
				case 0:
					next = num - 1;
					break;
				case 1:
					next = num + 1;
					break;
				case 2:
					next = num * 2;
				}
				
				if(next == k) {
					return arr[num];
				}
				
				if(next >= 0 && next < 100001 && arr[next] == 0) {
					arr[next] = arr[num] + 1;
					q.add(next);
				}
			}
		}
		return 0;
	}
}
