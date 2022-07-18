class Solution {
    public int solution(int[][] matrix_sizes) {
        int length = matrix_sizes.length + 1;
        int index = 0;
        int[] cost = new int[length];
        int[][] memo = new int[length][length--];

        do {
            cost[index] = matrix_sizes[index][0];
        } while (++index < length);
        cost[index] = matrix_sizes[index - 1][1];
        for (int i = 2; i <= length; i++) {
            for (int j = i; j <= length; j++) {
                dp(cost, memo, j - i, j);
            }
        }
        return memo[0][length];
    }

    void dp(int[] cost, int[][] memo, int start, int end) {
        int cs = cost[start];
        int ce = cost[end];
        int index = start + 1;
        int min = cs * cost[index] * ce + memo[start][index] + memo[index][end];

        while (++index < end) {
            min = Math.min(
                min
                , cs * cost[index] * ce + memo[start][index] + memo[index][end]
            );
        }
        memo[start][end] = min;
    }
}