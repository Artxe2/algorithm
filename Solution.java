class Solution {
    public int solution(int[][] board, int r, int c) {
        int answer = 66;
        int prev = r * 4 + c;
        int n = 0;
        int index = 0;
        int card;
        int[] yy;
        int[] field = new int[16];
        int[] cost = new int[16];
        int[] start = new int[7];
        int[] end = new int[7];
        boolean[] visit = new boolean[7];
        java.util.Deque<Integer> queue = new java.util.ArrayDeque<>();

        for (int i = 1; i < 7; i++) {
            visit[i] = true;
        }
        for (int y = 0; y < 4; y++) {
            yy = board[y];
            for (int x = 0; x < 4; x++) {
                card = yy[x];
                if (card > 0) {
                    if (visit[card]) {
                        n++;
                        visit[card] = false;
                        start[card] = index;
                    } else {
                        end[card] = index;
                    }
                    field[index] = card;
                }
                index++;
            }
        }
        for (int i = 1; i < 7; i++) {
            if (!visit[i]) {
                answer = backtracking(field, cost, start, end, visit,
                        n, prev, i, answer, 0, queue);
                answer = backtracking(field, cost, end, start, visit,
                        n, prev, i, answer, 0, queue);
            }
        }
        return answer + n * 2;
    }

    int backtracking(int[] field, int[] cost, int[] start, int[] end, boolean[] visit,
            int n, int prev, int index, int answer, int count,
            java.util.Deque<Integer> queue) {
        int from = start[index];
        int to = end[index];

        count += bfs(field, cost, prev, from, queue);
        count += bfs(field, cost, from, to, queue);
        if (--n == 0) {
            return Math.min(count, answer);
        } else if (count < answer) {
            field[from] = 0;
            field[to] = 0;
            visit[index] = true;
            for (int i = 1; i < 7; i++) {
                if (!visit[i]) {
                    answer = backtracking(field, cost, start, end, visit,
                            n, to, i, answer, count, queue);
                    answer = backtracking(field, cost, end, start, visit,
                            n, to, i, answer, count, queue);
                }
            }
            field[from] = index;
            field[to] = index;
            visit[index] = false;
        }
        return answer;
    }

    int bfs(int[] field, int[] cost, int from, int to,
            java.util.Deque<Integer> queue) {
        if (from == to) {
            return 0;
        }

        int curr;
        int c;
        int move;

        queue.clear();
        fill(cost, 16, 16);
        cost[from] = 0;
        queue.add(from);
        for (;;) {
            curr = queue.pop();
            c = cost[curr] + 1;
            if (curr < 12) {
                move = curr + 4;
                if (move == to) {
                    return c;
                }
                if (cost[move] > c) {
                    cost[move] = c;
                    queue.add(move);
                }
                if (move < 12 && field[move] == 0) {
                    do {
                        move += 4;
                    } while (move < 12 && field[move] == 0);
                    if (move == to) {
                        return c;
                    }
                    if (cost[move] > c) {
                        cost[move] = c;
                        queue.add(move);
                    }
                }

            }
            if (curr > 3) {
                move = curr - 4;
                if (move == to) {
                    return c;
                }
                if (cost[move] > c) {
                    cost[move] = c;
                    queue.add(move);
                }
                if (move > 3 && field[move] == 0) {
                    do {
                        move -= 4;
                    } while (move > 3 && field[move] == 0);
                    if (move == to) {
                        return c;
                    }
                    if (cost[move] > c) {
                        cost[move] = c;
                        queue.add(move);
                    }
                }

            }
            if (curr % 4 < 3) {
                move = curr + 1;
                if (move == to) {
                    return c;
                }
                if (cost[move] > c) {
                    cost[move] = c;
                    queue.add(move);
                }
                if (move % 4 < 3 && field[move] == 0) {
                    do {
                        move++;
                    } while (move % 4 < 3 && field[move] == 0);
                    if (move == to) {
                        return c;
                    }
                    if (cost[move] > c) {
                        cost[move] = c;
                        queue.add(move);
                    }
                }
            }
            if (curr % 4 > 0) {
                move = curr - 1;
                if (move == to) {
                    return c;
                }
                if (cost[move] > c) {
                    cost[move] = c;
                    queue.add(move);
                }
                if (move % 4 > 0 && field[move] == 0) {
                    do {
                        move--;
                    } while (move % 4 > 0 && field[move] == 0);
                    if (move == to) {
                        return c;
                    }
                    if (cost[move] > c) {
                        cost[move] = c;
                        queue.add(move);
                    }
                }
            }
        }
    }

    void fill(int[] array, int length, int value) {
        int index = 1;

        array[0] = value;
        do {
            System.arraycopy(array, 0, array, index, index);
            index += index;
        } while (index + index < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }
}