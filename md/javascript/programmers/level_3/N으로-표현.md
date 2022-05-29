```js
function solution(N, number) {
    let count = 0;
    let nn = N;
    let answer = 9;

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

function backtracking(N, number, count, acc, answer) {
    if (number == acc) {
        answer = count;
    } else {
        let nn = N;

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
```
 | 정확성 테스트 | 
 |  :-  | 
 | 테스트 1 〉	통과 (0.55ms, 30.1MB) | 
 | 테스트 2 〉	통과 (0.16ms, 30MB) | 
 | 테스트 3 〉	통과 (0.17ms, 30.2MB) | 
 | 테스트 4 〉	통과 (4.82ms, 32.8MB) | 
 | 테스트 5 〉	통과 (3.67ms, 32.7MB) | 
 | 테스트 6 〉	통과 (1.39ms, 32.9MB) | 
 | 테스트 7 〉	통과 (1.33ms, 33MB) | 
 | 테스트 8 〉	통과 (4.41ms, 32.6MB) | 
 | 테스트 9 〉	통과 (0.10ms, 29.9MB) | 

 | 채점 결과 | 
 | :- | 
 | 정확성: 100.0 | 
 | 합계: 100.0 / 100.0 | 

 || 
 | :- | 
 | 총합 > (16.60ms, 284.2MB) | 

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42895?language=javascript)