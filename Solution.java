class Solution {
    int best;
    int order;

    public int[] solution(int n, int[] info) {
        int index = 0;
        int score = 0;
        int length = 1 + n / 2; // branch and bound
        int[] temp = new int[11];
        int[] answer = new int[11];

        for (int i = 0; i < 10; i++) {
            if (info[i] > 0) {
                score -= 10 - i;
            }
        }
        while (index < length) {
            dfs(n, info, temp, answer, index++, score, 0);
        }
        return best > 0 ? answer : new int[] { -1 };
    }

    void dfs(int n, int[] info, int[] temp, int[] answer, int index, int score, int ord) {
        int apeach = info[index] + 1;
        int t = index;

        if (n >= apeach) {
            n -= apeach;
            score += (10 - index) * (apeach > 1 ? 2 : 1);
            ord += index * index;
            temp[index++] = apeach;
            if (n > 0) {
                while (index < 10) {
                    dfs(n, info, temp, answer, index++, score, ord);
                }
            } else {
                if (score > best || score == best && ord > order) {
                    best = score;
                    order = ord;
                    System.arraycopy(temp, 0, answer, 0, 11);
                }
            }
            temp[t] = 0;
        } else if (score > best || score == best && ord > order) {
            best = score;
            order = ord;
            System.arraycopy(temp, 0, answer, 0, 11);
            answer[10] = n;
        }
    }
}