import java.io.*;
import java.util.HashMap;

public class Main {
    static int cost;
    static int[] selectCount = new int[26];
    static int[] titleCount = new int[26];
    static Book[] books;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt;
        String[] ipts;

        cost = Integer.MAX_VALUE;
        String targetWord = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for(char ch: targetWord.toCharArray()) {
            titleCount[ch - 'A']++;
        }

        books = new Book[N];

        for(int i = 0; i < N; i++) {
            ipts = br.readLine().split(" ");
            books[i] = new Book(Integer.parseInt(ipts[0]), ipts[1]);
        }

        bt(0, 0, N);

        System.out.println(cost == Integer.MAX_VALUE ? -1 : cost);

    }

    public static void bt(int idx, int curCost, int depth){
        if(idx == depth){
            if(isDone()){
                cost = Math.min(curCost, cost);
            }
            return;
        }

        // 다음 책 고르는 경우
        for(char ch: books[idx].title.toCharArray()) {
            selectCount[ch - 'A']++;
        }
        bt(idx+1, curCost+books[idx].price, depth);

        // 다음 책 고르지 않는 경우
        for(char ch: books[idx].title.toCharArray()) {
            selectCount[ch - 'A']--;
        }
        bt(idx+1, curCost, depth);
    }

    public static boolean isDone(){
        for(int i = 0; i < titleCount.length; i++){
            if(titleCount[i] > selectCount[i]){
                return false;
            }
        }

        return true;
    }
}

class Book{
    public int price;
    public String title;

    public Book(int price, String title) {
        this.price = price;
        this.title = title;
    }
}
