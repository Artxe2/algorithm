```java
class Solution {
    public int solution(int[] citations) {
        int length = citations.length;

        quickSort(citations, 0, length);
        return parametricSearch(citations, length);
    }

    int parametricSearch(int[] citations, int length) {
        int start = 0;
        int mid;
        int end = length;

        while (start < end) {
            mid = (start + end + 1) / 2;
            if (citations[length - mid] >= mid) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    void quickSort(int[] array, int start, int end) {
        if (end - start > 1) {
            int left = start;
            int right = end;
            int mid = (start + end) / 2;
            int pivot = array[mid];

            array[mid] = array[start];
            left = partition(array, left, right, pivot);
            quickSort(array, start, left);
            quickSort(array, left + 1, end);
        }
    }

    int partition(int[] array, int left, int right, int pivot) {
        while (left < right) {
            while (left < right && pivot <= array[--right]);
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[++left] <= pivot);
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[right] = pivot;
        return left;
    }
}
```
 | 정확성 테스트 |
 |  :-  |
 | 테스트 1 〉 통과 (0.20ms, 75.3MB) |
 | 테스트 2 〉 통과 (0.32ms, 74.7MB) |
 | 테스트 3 〉 통과 (0.29ms, 75.3MB) |
 | 테스트 4 〉 통과 (0.30ms, 77MB) |
 | 테스트 5 〉 통과 (0.31ms, 78MB) |
 | 테스트 6 〉 통과 (0.38ms, 72.7MB) |
 | 테스트 7 〉 통과 (0.15ms, 73.3MB) |
 | 테스트 8 〉 통과 (0.05ms, 75.2MB) |
 | 테스트 9 〉 통과 (0.05ms, 74.4MB) |
 | 테스트 10 〉 통과 (0.23ms, 70.2MB) |
 | 테스트 11 〉 통과 (0.37ms, 74.8MB) |
 | 테스트 12 〉 통과 (0.07ms, 70.4MB) |
 | 테스트 13 〉 통과 (0.36ms, 77.8MB) |
 | 테스트 14 〉 통과 (0.34ms, 73.8MB) |
 | 테스트 15 〉 통과 (0.44ms, 78.9MB) |
 | 테스트 16 〉 통과 (0.02ms, 76.7MB) |

 | 채점 결과 |
 | :- |
 | 정확성: 100.0 |
 | 합계: 100.0 / 100.0 |

 ||
 | :- |
 | 총합 > (3.88ms, 1198.5MB) |

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42747?language=java)