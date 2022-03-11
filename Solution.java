class Solution {
    public int[] solution(int[] a, int[] s) {
        int length = s.length;
        int index = 0;
        int iLength = 1;
        int cases = 0;

        for (int i : s) {
            iLength = Math.max(iLength, i);
        }

        int[][] memo = new int[iLength][];

        for (int i = 1; i < iLength; i++) {
            cases += i;
            memo[i] = new int[cases];
        }
        for (int i = 0; i < length; i++) {
            s[i] = dp(memo, a, index, (index += s[i]));
        }
        PrintArray.print(memo);
        return s;
    }

    int dp(int[][] memo, int[] a, int index, int length) {
        PrintArray.print(java.util.Arrays.copyOfRange(a, index, length));
        int result = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
            }
        }
        return result;
    }
}