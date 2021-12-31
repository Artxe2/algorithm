```java
class Solution {
    int answer;

    public int solution(int n) {
        if (n < 4) {
            return n == 1 ? 1 : 0;
        }

        int[] xx = new int[n];

        for (int i = 0; i < n; i++) {
            backtracking(xx, i, 0, n);
        }
        return answer;
    }

    void backtracking(int[] xx, int x, int index, int n) {
        int p;

        for (int i = 0; i < index; i++) {
            p = xx[i];
            if (p == x || p + index - i == x || p - index + i == x) {
                return;
            }
        }
        xx[index++] = x;
        if (index == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                backtracking(xx, i, index, n);
            }
        }
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.02ms, 75.8MB) |
 | 테스트 2 〉 통과 (0.02ms, 63.9MB) |
 | 테스트 3 〉 통과 (0.02ms, 77.1MB) |
 | 테스트 4 〉 통과 (0.04ms, 75.2MB) |
 | 테스트 5 〉 통과 (0.14ms, 76.4MB) |
 | 테스트 6 〉 통과 (0.34ms, 87.6MB) |
 | 테스트 7 〉 통과 (0.74ms, 71MB) |
 | 테스트 8 〉 통과 (2.29ms, 74.6MB) |
 | 테스트 9 〉 통과 (6.97ms, 80.3MB) |
 | 테스트 10 〉 통과 (25.36ms, 84.6MB) |
 | 테스트 11 〉 통과 (126.97ms, 90.8MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (162.91ms, 857.3MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12952?language=java)