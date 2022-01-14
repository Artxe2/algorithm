```java
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
```
 | 정확성 테스트 | 
 |  :-  | 
 | 테스트 1 〉	통과 (6.81ms, 75.1MB) | 
 | 테스트 2 〉	통과 (0.03ms, 73.5MB) | 
 | 테스트 3 〉	통과 (0.03ms, 73.1MB) | 
 | 테스트 4 〉	통과 (0.02ms, 75.8MB) | 
 | 테스트 5 〉	통과 (0.03ms, 82.2MB) | 
 | 테스트 6 〉	통과 (0.03ms, 76.2MB) | 
 | 테스트 7 〉	통과 (0.03ms, 75.5MB) | 
 | 테스트 8 〉	통과 (0.03ms, 72.8MB) | 
 | 테스트 9 〉	통과 (0.03ms, 77.1MB) | 
 | 테스트 10 〉	통과 (0.05ms, 76.1MB) | 
 | 테스트 11 〉	통과 (0.03ms, 69MB) | 
 | 테스트 12 〉	통과 (0.02ms, 74.8MB) | 
 | 테스트 13 〉	통과 (0.03ms, 76.6MB) | 
 | 테스트 14 〉	통과 (0.10ms, 81.8MB) | 
 | 테스트 15 〉	통과 (0.02ms, 75.2MB) | 
 | 테스트 16 〉	통과 (0.03ms, 76.4MB) | 

 | 채점 결과 | 
 | :- | 
 | 정확성: 100.0 | 
 | 합계: 100.0 / 100.0 | 

 || 
 | :- | 
 | 총합 > (7.32ms, 1211.2MB) | 

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/92335?language=java)