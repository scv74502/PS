class Solution
{
    public int solution(int n, int a, int b)
    {
        if(n == 2) return 1;
        int answer = 0;                
        
        // a와 b가 같아지면 경기에서 만난다는 의미
        while (a != b) {
            // (번호 + 1) / 2를 하면 다음 라운드 번호가 됩니다.            
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        
        return answer;
    }
}