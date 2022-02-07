class Solution {
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int length = 0;
        int ym = board[0].length;
        int a = aloc[0] * ym + aloc[1];
        int b = bloc[0] * ym + bloc[1];
        boolean[] scaffolding = new boolean[board.length * ym];

        for (int[] r : board) {
            for (int i : r) {
                scaffolding[length++] = i > 0 ? true : false;
            }
        }
        return Math.abs(dfs(scaffolding, length, ym, a, b, 0));
    }

    int dfs(boolean[] scaffolding, int length, int ym, int a, int b, int count) {
        if (!scaffolding[a]) {
            return count;
        }

        int turn = 25;
        int temp;
        boolean isWinnable = false;

        scaffolding[a] = false;
        if (a >= ym && scaffolding[a - ym]) {
            temp = dfs(scaffolding, length, ym, b, a - ym, count + 1);
            if (!isWinnable) {
                if (temp > 0) {
                    isWinnable = true;
                    turn = temp;
                } else {
                    turn = Math.min(turn, temp);
                }
            } else if (temp > 0) {
                turn = Math.min(turn, temp);
            }
        }
        if (a + ym < length && scaffolding[a + ym]) {
            temp = dfs(scaffolding, length, ym, b, a + ym, count + 1);
            if (!isWinnable) {
                if (temp > 0) {
                    isWinnable = true;
                    turn = temp;
                } else {
                    turn = Math.min(turn, temp);
                }
            } else if (temp > 0) {
                turn = Math.min(turn, temp);
            }
        }
        if (a % ym > 0 && scaffolding[a - 1]) {
            temp = dfs(scaffolding, length, ym, b, a - 1, count + 1);
            if (!isWinnable) {
                if (temp > 0) {
                    isWinnable = true;
                    turn = temp;
                } else {
                    turn = Math.min(turn, temp);
                }
            } else if (temp > 0) {
                turn = Math.min(turn, temp);
            }
        }
        if (a % ym + 1 < ym && scaffolding[a + 1]) {
            temp = dfs(scaffolding, length, ym, b, a + 1, count + 1);
            if (!isWinnable) {
                if (temp > 0) {
                    isWinnable = true;
                    turn = temp;
                } else {
                    turn = Math.min(turn, temp);
                }
            } else if (temp > 0) {
                turn = Math.min(turn, temp);
            }
        }
        scaffolding[a] = true;
        return turn == 25 ? count : -turn;
    }
}