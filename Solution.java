class Solution {
    public int[] solution(long begin, long end) {
        int length = (int) (end - begin) + 1;
        int[] answer = new int[length];

        if (begin > 2) {
            answer[0] = findMod(begin);
        }
        for (int i = 1; i < length; i++) {
            answer[i] = findMod(begin + i);
        }
        return answer;
    }

    int findMod(long n) {
        int mod = (int) Math.min(10000000, n / 2);
        int max = (int) Math.min(mod, Math.sqrt(n));

        for (int i = (int) (n / mod) + (n % mod > 0 ? 1 : 0); i <= max; i++) {
            if (n % i == 0) {
                return (int) Math.max(n / i, n % i);
            }
        }
        return 1;
    }
}