class Solution {
    public int solution(int n, int rooks) {
        int answer = 0;
        int xl;
        boolean[][] triangle = new boolean[n][];

        rooks--;
        for (int i = 0; i < n; i++) {
            triangle[i] = new boolean[i * 2 + 1];
        }
        for (int i = 0; i < n; i++) {
            xl = i * 2 + 1;
            for (int j = 0; j < xl; j++) {
                answer += dfs(n, rooks, triangle, i, j);
            }
        }
        return answer;
    }

    int dfs(int n, int rooks, boolean[][] triangle, int i, int j) {
        if (rooks == 0) {
            return 1;
        }
        triangle[i][j] = true;
        rooks--;

        int answer = 0;
        int xl;
        int x = j + 1;

        for (int y = i; y < n; y++) {
            xl = y * 2 + 1;
            for (; x < xl; x++) {
                if (verifyRook(triangle, y, x)) {
                    answer += dfs(n, rooks, triangle, y, x);
                }
            }
            x = 0;
        }
        triangle[i][j] = false;
        return answer;
    }

    boolean verifyRook(boolean[][] triangle, int y, int x) {
        int d = triangle[y].length - x;
        int length;
        boolean[] temp;
        
        for (int i = 0; i < y; i++) {
            temp = triangle[i];
            length = temp.length;
            if (length > x && temp[x]) {
                return false;
            }
            if (x % 2 == 0) {
                if (length > x + 1 && temp[x + 1]) {
                    return false;
                }
            } else if (length > x - 1 && temp[x - 1]) {
                return false;
            }
            if (length >= d && temp[length - d]) {
                return false;
            }
            if (x % 2 == 0) {
                if (length > d && temp[length - d - 1]) {
                    return false;
                }
            } else if (length + 1 >= d && temp[length - d + 1]) {
                return false;
            }
        }
        temp = triangle[y];
        for (int i = 0; i < x; i++) {
            if (temp[i]) {
                return false;
            }
        }
        return true;
    }
}