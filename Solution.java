class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int curr = 0;
        int max = 1;
        int[] customers = new int[722];

        for (int[] a : timetable) {
            customers[a[0] - 600]++;
            customers[a[1] - 599]--;
        }
        for (int i : customers) {
            curr += i;
            max = Math.max(max, curr);
        }
        if (max == 1) {
            return 0;
        }
        if (max < 5) {
            return (n - 1) * 4 / max;
        }
        if (max > n * n / 2 + (max % 2 > 0 ? 1 : 0)) {
            return 1;
        }

        int length = n * n;
        int start = 2;
        int mid;
        int end = n - 2;
        boolean[] visit = new boolean[length];

        while (start < end) {
            mid = (start + end + 1) / 2;
            if (countMax(n, mid, length, visit) >= m) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    int countMax(int n, int gap, int length, boolean[] visit) {
        int result = 0;
        int temp;
        int index;
        int y;
        int x;
        int from;
        int to;

        for (int i = 0; i < gap; i++) {
            reset(visit, length);
            temp = 0;
            index = i;
            do {
                if (!visit[index]) {
                    y = index / n;
                    x = index % n;
                    for (int j = 1; j < gap && ++y * n < length; j++) {
                        from = y * n + Math.max(x - gap + j + 1, 0);
                        to = y * n + Math.min(x + gap - j, n);
                        while (from < to) {
                            visit[from++] = true;
                        }
                    }
                    for (int j = 0; j < Math.min(gap, n - x); j++) {
                        visit[index++] = true;
                    }
                    temp++;
                } else {
                    index++;
                }
            } while (index < length);
            result = Math.max(result, temp);
        }
        return result;
    }

    void reset(boolean[] visit, int length) {
        int index = 1;

        visit[0] = false;
        do {
            System.arraycopy(visit, 0, visit, index, index);
            index += index;
        } while (index * 2 < length);
        if (index < length) {
            System.arraycopy(visit, 0, visit, index, length - index);
        }
    }
}