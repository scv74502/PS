import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] mdays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	// 월별 날짜 수
	static int[] wdays = {1, 2, 3, 4, 5, 6, 7};	// 일주일의 요일 수, 월요일부터 일요일까지
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	// 2019 ~ N년
		int cnt = 0;	// 13일 금요일을 세는 변수
		int totday = 13;	// 총 날짜, 1월 13일부터 시작함
		for(int i = 2019; i <= N; i++) {
			if((i % 4 == 0 && i% 100 != 0) || i % 400 == 0) {	// 윤년 체크
				mdays[2] = 29;	// 윤년이면 2월 29일
			} else {
				mdays[2] = 28;	// 윤년 아님녀 2월 28일
			}
			
			for(int j = 1; j <= 12; j++) {	// 한 해의 월별로 체크
				if(totday % 7 == 4) {	// days % 7 == 1이면 화요일이고, 4이면 금요일
					cnt++;
				}
				totday += mdays[j];
			}
		}
		bw.write(cnt+"\n");
		bw.flush();
	}
}
