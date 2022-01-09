class Solution {
    public int solution(int n) {
        int mod = 1234567;
        int answer = 0;
        int prev = 1;
        int temp;

        /* fibonacci */
        while (n-- >= 0) {
            temp = answer;
            answer = (answer + prev) % mod;
            prev = temp;
        }
        return answer;
    }
}