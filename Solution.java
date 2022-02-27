class Solution {
    public int solution(int n, int[] cores) {
        int length = cores.length;
        int start = 1;
        int mid = 0;
        int end = (n / length + 1) * cores[length - 1];
        int temp;
        int work = 0;

        while (start < end) {
            mid = (start + end - 1) / 2;
            temp = 0;
            for (int i : cores) {
                temp += mid / i;
            }
            if (temp >= n) {
                work = temp;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        work -= n;
        for (;;) {
            System.out.println(mid + ": " + (length - 1) + ", " + work);
            if (mid % cores[--length] == 0 && work-- == 0) {
                return length + 1;
            }
        }
    }
}