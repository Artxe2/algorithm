```java
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = calculate(array, commands[i]);
        }
        return answer;
    }

    int calculate(int[] array, int[] command) {
        int start = command[0] - 1;
        int end = command[1];
        int target = 0;
        int count;
        int equals;

        for (int j = start; j < end; j++) {
            target = array[j];
            count = command[2];
            equals = 0;
            for (int k = start; k < end; k++) {
                if (target > array[k]) {
                    count--;
                } else if (target == array[k]) {
                    equals++;
                }
            }
            if (count == 1 || count > 1 && count - equals < 1) {
                break;
            }
        }
        return target;
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.03ms, 52.3MB) |
 | 테스트 2 〉 통과 (0.03ms, 52.4MB) |
 | 테스트 3 〉 통과 (0.02ms, 51.8MB) |
 | 테스트 4 〉 통과 (0.02ms, 53.1MB) |
 | 테스트 5 〉 통과 (0.02ms, 52.4MB) |
 | 테스트 6 〉 통과 (0.03ms, 52.3MB) |
 | 테스트 7 〉 통과 (0.02ms, 53.7MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (0.17ms, 368.0MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42748?language=java)