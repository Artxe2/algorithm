```java
class Solution {
    public int solution(int n) {
        int mod = 1000000007;
        int answer = 0;
        int prev = 1;
        int temp;

        /* fibonacci */
        while (n-- >= 0) {
            temp = answer;
            answer = (answer + prev) % mod;
            prev = temp;
        }
        return answer;
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.12ms, 77.8MB) |
 | 테스트 2 〉 통과 (0.03ms, 72.1MB) |
 | 테스트 3 〉 통과 (0.09ms, 71.6MB) |
 | 테스트 4 〉 통과 (0.15ms, 81.3MB) |
 | 테스트 5 〉 통과 (0.03ms, 72.8MB) |
 | 테스트 6 〉 통과 (0.12ms, 77.2MB) |
 | 테스트 7 〉 통과 (0.04ms, 78.8MB) |
 | 테스트 8 〉 통과 (0.12ms, 78.9MB) |
 | 테스트 9 〉 통과 (0.10ms, 74MB) |
 | 테스트 10 〉 통과 (0.15ms, 74.8MB) |
 | 테스트 11 〉 통과 (0.08ms, 76.4MB) |
 | 테스트 12 〉 통과 (0.04ms, 75.6MB) |
 | 테스트 13 〉 통과 (0.04ms, 76.7MB) |
 | 테스트 14 〉 통과 (0.15ms, 76.1MB) |

 | 효율성 테스트 |
 | :- |
 | 테스트 1 〉 통과 (0.36ms, 52.5MB) |
 | 테스트 2 〉 통과 (0.88ms, 52MB) |
 | 테스트 3 〉 통과 (0.60ms, 51.7MB) |
 | 테스트 4 〉 통과 (0.47ms, 52.1MB) |
 | 테스트 5 〉 통과 (0.76ms, 52.2MB) |
 | 테스트 6 〉 통과 (0.98ms, 52.1MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 70.0 |
 | 효율성: 30.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (5.31ms, 1376.7MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12900?language=java)