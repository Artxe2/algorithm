```java
class Solution {
    public int solution(int n) {
        if (n % 2 > 0) {
            return 0;
        }
        if (n == 2) {
            return 3;
        }
        n = n / 2;

        int mod = 1000000007;
        long temp;
        long[] answer = new long[n + 1];
        long[] reverse = new long[n + 1];

        answer[1] = 3;
        answer[2] = 11;
        for (int i = 2; i <= n; i++) {
            temp = reverse[i - 1] + answer[i - 2] * 2;
            reverse[i] = temp;
            answer[i] = (answer[i - 1] * 3 + temp + 2) % mod;
        }
        return (int) answer[n];
    }
}
```
 | 정확성 테스트 | 
 |  :-  | 
 | 테스트 1 〉	통과 (0.09ms, 75.3MB) | 
 | 테스트 2 〉	통과 (0.11ms, 72.2MB) | 
 | 테스트 3 〉	통과 (0.13ms, 72.7MB) | 
 | 테스트 4 〉	통과 (0.15ms, 71.5MB) | 
 | 테스트 5 〉	통과 (0.03ms, 75.2MB) | 
 | 테스트 6 〉	통과 (0.08ms, 76.7MB) | 
 | 테스트 7 〉	통과 (0.11ms, 76.5MB) | 
 | 테스트 8 〉	통과 (0.13ms, 74.1MB) | 
 | 테스트 9 〉	통과 (0.12ms, 75.7MB) | 
 | 테스트 10 〉	통과 (0.07ms, 75.7MB) | 
 | 테스트 11 〉	통과 (0.09ms, 71.4MB) | 
 | 테스트 12 〉	통과 (0.06ms, 76.1MB) | 
 | 테스트 13 〉	통과 (0.07ms, 76.8MB) | 
 | 테스트 14 〉	통과 (0.08ms, 77.4MB) | 

 | 효율성 테스트 | 
 | :- | 
 | 테스트 1 〉	통과 (0.14ms, 52.1MB) | 
 | 테스트 2 〉	통과 (0.25ms, 52.1MB) | 
 | 테스트 3 〉	통과 (0.25ms, 52.4MB) | 
 | 테스트 4 〉	통과 (0.22ms, 52.1MB) | 
 | 테스트 5 〉	통과 (0.27ms, 51.9MB) | 
 | 테스트 6 〉	통과 (0.22ms, 52.4MB) | 

 | 채점 결과 | 
 | :- | 
 | 정확성: 70.0 | 
 | 효율성: 30.0 | 
 | 합계: 100.0 / 100.0 | 

 || 
 | :- | 
 | 총합 > (2.67ms, 1360.3MB) | 

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12902?language=java)