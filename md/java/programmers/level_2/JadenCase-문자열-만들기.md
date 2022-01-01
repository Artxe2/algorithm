```java
class Solution {
    public String solution(String s) {
        int length = s.length();
        int index = 0;
        char c;
        char[] answer = s.toCharArray();

        while (index < length) {
            c = answer[index];
            while (c < 48) {
                c = answer[++index];
            }
            if (c > 90) {
                answer[index] -= 32;
            }
            while (++index < length) {
                c = answer[index];
                if (c < 48) {
                    index++;
                    break;
                }
                if (c < 97 && c > 57) {
                    answer[index] += 32;
                }
            }
        }
        return new String(answer);
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.03ms, 74.7MB) |
 | 테스트 2 〉 통과 (0.02ms, 76.1MB) |
 | 테스트 3 〉 통과 (0.04ms, 75.7MB) |
 | 테스트 4 〉 통과 (0.03ms, 74.5MB) |
 | 테스트 5 〉 통과 (0.04ms, 77.4MB) |
 | 테스트 6 〉 통과 (0.03ms, 77.7MB) |
 | 테스트 7 〉 통과 (0.04ms, 72.8MB) |
 | 테스트 8 〉 통과 (0.02ms, 73.2MB) |
 | 테스트 9 〉 통과 (0.03ms, 73.5MB) |
 | 테스트 10 〉 통과 (0.02ms, 73.5MB) |
 | 테스트 11 〉 통과 (0.02ms, 75.8MB) |
 | 테스트 12 〉 통과 (0.02ms, 74.7MB) |
 | 테스트 13 〉 통과 (0.02ms, 72.7MB) |
 | 테스트 14 〉 통과 (0.02ms, 66.3MB) |
 | 테스트 15 〉 통과 (0.04ms, 75.1MB) |
 | 테스트 16 〉 통과 (0.02ms, 79.4MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (0.44ms, 1193.1MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12951?language=java)