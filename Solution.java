class Solution {
    public int solution(int n, int[] cores) {
        int length = cores.length;
        int start = 0;
        int mid = 0;
        int end = (n / length + 1) * 10000;
        int temp;
        int work = 0;
        int index = 0;

        while (start < end) {
            mid = (start + end + 1) / 2;
            temp = 0;
            for (int i : cores) {
                temp += mid / i + (mid % i > 0 ? 1 : 0);
            }
            if (temp < n) {
                work = temp;
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        work = n - work;
        for (;;) {
            if (start % cores[index++] == 0 && --work == 0) {
                return index;
            }
        }
    }
}