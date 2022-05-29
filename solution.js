let answer = 9;

function solution(N, number) {
    let count = 0;
    let nn = N;

    while (++count < answer) {
        backtracking(N, number, count, nn);
        if (answer < count) {
            break;
        }
        backtracking(N, number, count, -nn);
        nn = nn * 10 + N;
    }
    return answer < 9 ? answer : -1;
}

function backtracking(N, number, count, acc) {
    if (number == acc) {
        answer = count;
    } else {
        let nn = N;

        while (++count < answer) {
            backtracking(N, number, count, acc + nn);
            if (answer < count) {
                break;
            }
            backtracking(N, number, count, acc - nn);
            if (answer < count) {
                break;
            }
            backtracking(N, number, count, acc * nn);
            if (answer < count) {
                break;
            }
            backtracking(N, number, count, acc / nn);
            nn = nn * 10 + N;
        }
    }
}
/* * * * */
console.log(solution(5, 12));