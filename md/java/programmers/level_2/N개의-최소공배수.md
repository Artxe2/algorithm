```java
class Solution {
    public int solution(int[] arr) {
        int length = arr.length;
        int min = arr[0];
        int curr;

        for (int i = 1; i < length; i++) {
            curr = arr[i];
            min = min * curr / (min > curr ? gcd(min, curr) : gcd(curr, min));
        }
        return min;
    }

    int gcd(int b, int s) {
        b %= s;
        if (b == 0) {
            return s;
        }
        return gcd(s, b);
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.02ms, 73.1MB) |
 | 테스트 2 〉 통과 (0.02ms, 76.9MB) |
 | 테스트 3 〉 통과 (0.01ms, 73.2MB) |
 | 테스트 4 〉 통과 (0.02ms, 77.2MB) |
 | 테스트 5 〉 통과 (0.02ms, 75.1MB) |
 | 테스트 6 〉 통과 (0.02ms, 75.3MB) |
 | 테스트 7 〉 통과 (0.01ms, 74.6MB) |
 | 테스트 8 〉 통과 (0.02ms, 75.4MB) |
 | 테스트 9 〉 통과 (0.03ms, 73.6MB) |
 | 테스트 10 〉 통과 (0.02ms, 73.5MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (0.19ms, 747.9MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12953?language=java)