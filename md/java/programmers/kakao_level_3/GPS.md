```java
class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int length = gps_log.length;
        int index = 1;
        int fix;
        int[] prev = new int[n];
        int[] curr = new int[n];
        int[] temp;
        int[][] graph = toGraph(n, edge_list);

        for (int i = 0; i < length; i++) {
            gps_log[i]--;
        }
        fill(curr, n, --length);
        curr[gps_log[0]] = 0;
        while (index < length) {
            temp = prev;
            prev = curr;
            curr = temp;
            for (int i = 0; i < n; i++) {
                fix = prev[i];
                for (int j : graph[i]) {
                    fix = Math.min(fix, prev[j]);
                }
                if (i != gps_log[index]) {
                    fix++;
                }
                curr[i] = fix;
            }
            index++;
        }
        fix = curr[gps_log[length]];
        for (int i : graph[gps_log[length]]) {
            fix = Math.min(fix, curr[i]);
        }
        return fix < length ? fix : -1;
    }

    int[][] toGraph(int n, int[][] edge_list) {
        int a0;
        int a1;
        int[] visit = new int[n];
        int[][] graph = new int[n][];

        for (int[] a : edge_list) {
            visit[a[0] - 1]++;
            visit[a[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[visit[i]];
        }
        fill(visit, n, 0);
        for (int[] a : edge_list) {
            a0 = a[0] - 1;
            a1 = a[1] - 1;
            graph[a0][visit[a0]++] = a1;
            graph[a1][visit[a1]++] = a0;
        }
        return graph;
    }

    void fill(int[] array, int length, int value) {
        int index = 1;

        array[0] = value;
        do {
            System.arraycopy(array, 0, array, index, index);
            index += index;
        } while (index * 2 < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (18.97ms, 90.1MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (18.97ms, 90.1MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/1837?language=java)