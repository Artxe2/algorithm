class Solution {
    public int solution(int[][] board, int[][] skill) {
        int length = board.length;
        int ym = board[0].length;
        int answer = 0;
        int startY;
        int startX;
        int endY;
        int endX;
        int degree;
        int index;
        int acc = 0;
        int[] prefixSum = new int[(length + 1) * ym + 1];

        for (int[] a : skill) {
            startY = a[1];
            startX = a[2];
            endY = a[3];
            endX = a[4];
            degree = a[0] == 1 ? -a[5] : a[5];
            prefixSum[startY * ym + startX] += degree;
            prefixSum[startY * ym + endX + 1] -= degree;
            prefixSum[(endY + 1) * ym + startX] -= degree;
            prefixSum[(endY + 1) * ym + endX + 1] += degree;
        }
        for (int i = 0; i < ym; i++) {
            index = i;
            for (int j = 0; j < length; j++) {
                prefixSum[index + ym] += prefixSum[index];
                index += ym;
            }
        }
        index = 0;
        for (int[] a : board) {
            for (int i : a) {
                acc += prefixSum[index++];
                i += acc;
                if (i > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}