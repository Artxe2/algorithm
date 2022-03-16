class Solution {
    private static final int MAX = 46; // log2(1e9) + log2(200001 - log2(1e9))

    // private static int log2(double d) {
    //     return (int) (Math.log(d) / Math.log(2));
    // }

    public int[] solution(int[] a, int[] s) {
        int length = s.length;
        int start = 0;
        int iLength = 1;

        for (int i : s) {
            iLength = Math.max(iLength, i);
        }

        int[][] memo = new int[iLength][MAX];

        memo[0][0] = 1;
        for (int i = 0; i < length; i++) {
            s[i] = dp(memo, a, start, (start += s[i]));
        }
        return s;
    }

    int dp(int[][] memo, int[] a, int start, int end) {
        int length = end - start;
        int result = 1;

        for (int i = 1; i < length; i++) {
            fill(memo[i], MAX, 0);
            memo[i][0] = result;
            result = synthesis(memo, a, start, i, result);
        }
        PrintArray.print(memo[length - 1]);
        return result;
    }

    int synthesis(int[][] memo, int[] a, int start, int i, int total) {
        int result;
        int j = 1;
        int k = i - 1;
        int p;
        long x = a[start + i];
        long y;

        for (;;) {
            y = a[start + k];
            p = 0;
            while (y < x) {
                y *= 2;
                p++;
            }
            if (y > x) {
                break;
            }
            result = memo[k][p];
            if (result == 0) {
                break;
            }
            total += result;
            memo[i][j] = result;
            do {
                y -= a[start + k--];
            } while (y > 0);
            if (k < 0) {
                break;
            }
            x *= 2;
            j++;
        }
        return total;
    }

    void fill(int[] array, int length, int value) {
        array[0] = value;
        if (length == 1) {
            return;
        }

        int index = 1;

        do {
            System.arraycopy(array, 0, array, index, index);
            index += index;
        } while (index * 2 < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }
}