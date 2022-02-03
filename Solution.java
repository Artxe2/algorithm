class Solution {
    public int solution(int[][] board) {
        int length = board.length;
        int ym = length * 2;
        int answer = 1;
        int size = 1;
        int goal = length * ym - 3;
        int curr;
        int y;
        int x;
        int move;
        boolean[] visit = new boolean[goal + 3];
        java.util.Deque<Integer> queue = new java.util.ArrayDeque<>();

        visit[2] = true;
        queue.add(2);
        for (;;) {
            curr = queue.pollFirst();
            y = curr / 2 / length;
            x = (curr / 2) % length;
            if (curr % 2 > 0) {
                if (y > 1 && !visit[move = curr - ym] && board[y - 2][x] == 0) {
                    visit[move] = true;
                    queue.add(move);
                }
                if (y + 1 < length
                        && !visit[move = curr + ym] && board[y + 1][x] == 0) {
                    if (move > goal) {
                        return answer;
                    }
                    visit[move] = true;
                    queue.add(move);
                }
                if (x > 0 && board[y][x - 1] == 0 && board[y - 1][x - 1] == 0) {
                    if (!visit[move = curr - 2]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr - ym - 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr - 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                }
                if (x + 1 < length
                        && board[y][x + 1] == 0 && board[y - 1][x + 1] == 0) {
                    if (!visit[move = curr + 2]) {
                        if (move > goal) {
                            return answer;
                        }
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr - ym + 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr + 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                }
            } else {
                if (x > 1 && !visit[move = curr - 2] && board[y][x - 2] == 0) {
                    visit[move] = true;
                    queue.add(move);
                }
                if (x + 1 < length
                        && !visit[move = curr + 2] && board[y][x + 1] == 0) {
                    if (move > goal) {
                        return answer;
                    }
                    visit[move] = true;
                    queue.add(move);
                }
                if (y > 0 && board[y - 1][x] == 0 && board[y - 1][x - 1] == 0) {
                    if (!visit[move = curr - ym]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr - 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr + 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                }
                if (y + 1 < length
                        && board[y + 1][x] == 0 && board[y + 1][x - 1] == 0) {
                    if (!visit[move = curr + ym]) {
                        if (move > goal) {
                            return answer;
                        }
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr + ym - 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                    if (!visit[move = curr + ym + 1]) {
                        visit[move] = true;
                        queue.add(move);
                    }
                }
            }
            if (--size == 0) {
                answer++;
                size = queue.size();
            }
        }
    }
}