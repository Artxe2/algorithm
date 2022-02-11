class Solution {
    public int solution(String arr[]) {
        int length = arr.length;
        int index = 1;
        int answer = parseInt(arr[0]);

        while (arr[index++].charAt(0) == '+') {
            answer += parseInt((arr[index++]));
            if (index == length) {
                return answer;
            }
        }

        int[] numbers =parseInt(arr, length, index);

        return branchAndBound(numbers, length, index, answer);
    }

    int branchAndBound(int[] numbers, int length, int index, int answer) {
        answer -= numbers[index++];
        if (index == length) {
            return answer;
        }
        if (numbers[index++] < 0) {
            do {
                answer += numbers[index];
                index += 2;
            } while (index < length);
            return answer;
        }

        int cost = numbers[index++];

        if (index == length) {
            return answer + cost;
        }
        while (numbers[index++] >= 0) {
            cost += numbers[index++];
            if (index == length) {
                return answer + cost;
            }
        }

        int minusMinus = answer - cost + sumAllTheRest(numbers, length, index);

        return Math.max(minusMinus, 
                branchAndBound(numbers, length, index, answer + cost));
    }

    int sumAllTheRest(int[] numbers, int length, int index) {
        int result = numbers[index];

        index += 2;
        while (index < length) {
            result += numbers[index];
            index += 2;
        }
        return result;
    }

    int parseInt(String s) {
        int index = 0;
        int length = s.length();
        int result = 0;

        for (;;) {
            result += s.charAt(index++) - 48;
            if (index < length) {
                result *= 10;
            } else {
                return result;
            }
        }
    }

    int[] parseInt(String[] arr, int length, int index) {
        int[] numbers = new int[length];

        do {
            numbers[index] = parseInt(arr[index++]);
            if (index == length) {
                return numbers;
            }
            if (arr[index].charAt(0) == '-') {
                numbers[index]--;
            }
        } while (++index < length);
        return numbers;
    }

    public static void main(String[] args) {
        int answer = new Solution().solution(new String[] {
            "5", "+", "3", "-", "1", "-", "2", "+", "4"
        });

        System.out.println(answer + ": " + (answer == 3));
    }
}