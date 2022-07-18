int backtracking(int N, int number, int count, int acc, int answer);

int solution(int N, int number) {
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
/* * * * */
#include <iostream>

using namespace std;

int main() {
    std::cout << solution(5, 12);
    return 0;
}