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

print(solution(5, 12))