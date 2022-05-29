```java
class Solution {
    public int solution(int N, int number) {
        int count = 0;
        int nn = N;
        int answer = 9;

        while (++count < answer) {
            answer = backtracking(N, number, count, nn, answer);
            if (answer < count) {
                break;
            }
            answer = backtracking(N, number, count, -nn, answer);
            nn = nn * 10 + N;
        }
        return answer < 9 ? answer : -1;
    }

    int backtracking(int N, int number, int count, int acc, int answer) {
        if (number == acc) {
            answer = count;
        } else {
            int nn = N;

            while (++count < answer) {
                answer = backtracking(N, number, count, acc + nn, answer);
                if (answer < count) {
                    break;
                }
                answer = backtracking(N, number, count, acc - nn, answer);
                if (answer < count) {
                    break;
                }
                answer = backtracking(N, number, count, acc * nn, answer);
                if (answer < count) {
                    break;
                }
                answer = backtracking(N, number, count, acc / nn, answer);
                nn = nn * 10 + N;
            }
        }
        return answer;
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.33ms, 80MB) |
 | 테스트 2 〉 통과 (0.12ms, 76.4MB) |
 | 테스트 3 〉 통과 (0.12ms, 75.3MB) |
 | 테스트 4 〉 통과 (1.63ms, 76.7MB) |
 | 테스트 5 〉 통과 (0.80ms, 79.8MB) |
 | 테스트 6 〉 통과 (0.37ms, 73.4MB) |
 | 테스트 7 〉 통과 (0.39ms, 73.3MB) |
 | 테스트 8 〉 통과 (1.40ms, 75.4MB) |
 | 테스트 9 〉 통과 (0.01ms, 79.2MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (5.17ms, 689.5MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42895?language=java)