class Solution {
    public int solution(int n) {
        if (n % 2 > 0) {
            return 0;
        }
        if (n == 2) {
            return 3;
        }
        n = n / 2;
        
        int mod = 1000000007;
        long temp;
        long[] answer = new long[n + 1];
        long[] reverse = new long[n + 1];

        answer[1] = 3;
        answer[2] = 11;
        for (int i = 2; i <= n; i++) {
            temp = reverse[i - 1] + answer[i - 2] * 2;
            reverse[i] = temp;
            answer[i] = (answer[i - 1] * 3 + temp + 2) % mod;
        }
        return (int) answer[n];
    }
}