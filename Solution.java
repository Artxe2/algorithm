class Solution {
    public int[] solution(long begin, long end) {
        int length = (int) (end - begin) + 1;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            if (begin + i > 1) {
                answer[i] = findMod(begin + i);
            }
        }
        return answer;
    }

    int findMod(long n) {
        int mod = (int) Math.min(10000000, n / 2);
        int max = (int) Math.min(mod, Math.sqrt(n));

        for (int i = (int) Math.max(2, (n / mod)); i <= max; i++) {
            if (n % i == 0) {
                return (int) Math.max(n / i, n % i);
            }
        }
        return 1;
    }
}