```java
class Solution {
    public long[] solution(int x, int n) {
        long acc = x;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = acc;
            acc += x;
        }
        return answer;
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.02ms, 74MB) |
 | 테스트 2 〉 통과 (0.02ms, 73.3MB) |
 | 테스트 3 〉 통과 (0.03ms, 81.1MB) |
 | 테스트 4 〉 통과 (0.03ms, 80.4MB) |
 | 테스트 5 〉 통과 (0.02ms, 81.2MB) |
 | 테스트 6 〉 통과 (0.02ms, 71.2MB) |
 | 테스트 7 〉 통과 (0.04ms, 76.6MB) |
 | 테스트 8 〉 통과 (0.03ms, 78.2MB) |
 | 테스트 9 〉 통과 (0.04ms, 78.8MB) |
 | 테스트 10 〉 통과 (0.01ms, 76.7MB) |
 | 테스트 11 〉 통과 (0.03ms, 82.4MB) |
 | 테스트 12 〉 통과 (0.03ms, 88.6MB) |
 | 테스트 13 〉 통과 (0.03ms, 76.6MB) |
 | 테스트 14 〉 통과 (0.04ms, 78.8MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (0.39ms, 1097.9MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12954?language=java)