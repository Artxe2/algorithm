import javax.crypto.Cipher;

class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int curr = 0;
        int max = 1;
        int[] customers = new int[721];

        for (int[] a : timetable) {
            customers[a[0] - 600]++;
            customers[a[1] - 600]--;
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

    int countMax(int n, int m, int length, boolean[] visit) {
        int x = m / 2;
        int y = m - x;
        int xs = (n - 1) % m;
        int col = (n - 1) / m + 1;
        int row = (n - 1) / y + 1;

        if (x > xs) {
            return col * row - row / 2;
        }
        if (x == xs) {
            return col * row;
        }

        int result = 0;

        reset(visit, length);
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                for (int j = 0; j < m; j++) {
                    
                }
                result++;
            }
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

    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(4, 5, Gson.fromJson(int[][].class, "[[1140,1200],[1150,1200],[1100,1200],[1210,1300],[1220,1280]]"));
        System.out.println(answer + " == 4: " + (answer == 4));
    
    }
}