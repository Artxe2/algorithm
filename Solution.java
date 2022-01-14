class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int index = n;
        int digit = 0;
        long p;

        while (index > 0) {
            digit++;
            index /= k;
        }

        int length = digit;
        int[] number = new int[length];

        do {
            number[--digit] = n % k;
            n /= k;
        } while (digit > 0);
        for (int i = 0; i < length; i++) {
            if (number[i] == 0) {
                if (index < i) {
                    p = number[index++];
                    while (index < i) {
                        p *= 10;
                        p += number[index++];
                    }
                    if (verifyPrimeNumber(p)) {
                        answer++;
                    }
                }
                index++;
            }
        }
        if (index < length) {
            p = number[index++];
            while (index < length) {
                p *= 10;
                p += number[index++];
            }
            if (verifyPrimeNumber(p)) {
                answer++;
            }
        }
        return answer;
    }

    boolean verifyPrimeNumber(long p) {
        if (p < 4) {
            return p > 1;
        }
        if (p % 2 == 0) {
            return false;
        }

        double sqrt = Math.sqrt(p);

        for (int i = 3; i <= sqrt; i += 2) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}