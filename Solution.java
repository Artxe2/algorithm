class Solution {
    public int solution(int n) {
        int i = 1;
        int j;
        int sum = 1;
        int[] memo = new int[n + 1];

        memo[1] = 1;
        while (i < n) {
            j = 1;
            sum *= 2;
            do {
                sum += memo[j] * memo[i - j++];
            } while (j < i);
            memo[++i] = sum;
        }
        return memo[n];
    }
}