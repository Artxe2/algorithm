```py
def solution(N, number):
    count = 1
    nn = N
    answer = 9

    while count < answer:
        answer = backtracking(N, number, count, nn, answer)
        if answer < count:
            break
        answer = backtracking(N, number, count, -nn, answer)
        nn = nn * 10 + N
        count += 1
    if answer < 9:
        return answer
    return -1



def backtracking(N, number, count, acc, answer):
    if (number == acc):
        answer = count
    else:
        nn = N
        count += 1
        while count < answer:
            answer = backtracking(N, number, count, acc + nn, answer)
            if answer < count:
                break
            answer = backtracking(N, number, count, acc - nn, answer)
            if answer < count:
                break
            answer = backtracking(N, number, count, acc * nn, answer)
            if answer < count:
                break
            answer = backtracking(N, number, count, acc / nn, answer)
            nn = nn * 10 + N
            count += 1
    return answer
```
 | 정확성 테스트 | 
 |  :-  | 
 | 테스트 1 〉	통과 (1.10ms, 10.3MB) | 
 | 테스트 2 〉	통과 (0.20ms, 10.2MB) | 
 | 테스트 3 〉	통과 (0.23ms, 10.3MB) | 
 | 테스트 4 〉	통과 (36.31ms, 10.2MB) | 
 | 테스트 5 〉	통과 (9.23ms, 10.1MB) | 
 | 테스트 6 〉	통과 (1.76ms, 10.2MB) | 
 | 테스트 7 〉	통과 (1.57ms, 10.2MB) | 
 | 테스트 8 〉	통과 (26.43ms, 10.2MB) | 
 | 테스트 9 〉	통과 (0.00ms, 10.1MB) | 

 | 채점 결과 | 
 | :- | 
 | 정확성: 100.0 | 
 | 합계: 100.0 / 100.0 | 

 || 
 | :- | 
 | 총합 > (76.83ms, 91.8MB) | 

[문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42895?language=python3)