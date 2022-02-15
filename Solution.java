class Solution {
    public int solution(int[] food_times, long k) {
        int length = food_times.length;
        int size = 0;
        int turn = 0;
        int answer = 0;
        int[] queue = new int[length];

        for (int i : food_times) {
            offer(queue, size++, i);
        }
        while (k >= size) {
            k -= size;
            turn++;
            while (turn == queue[0]) {
                poll(queue, size--);
                if (size == 0) {
                    return -1;
                }
            }
        }
        for (;;) {
            if (food_times[answer++] > turn && k-- == 0) {
                return answer;
            }
        }
    }

    void offer(int[] queue, int size, int e) {
        if (size == 0) {
            queue[0] = e;
        } else {
            siftUp(queue, size, e);
        }
    }

    int poll(int[] queue, int size) {
        int result = queue[0];

        siftDown(queue, size);
        return result;
    }

    void siftUp(int[] queue, int size, int e) {
        int parent;
        int p;

        while (size > 0) {
            parent = (size - 1) / 2;
            p = queue[parent];
            if (verifyOrder(p, e)) {
                break;
            }
            queue[size] = p;
            size = parent;
        }
        queue[size] = e;
    }

    void siftDown(int[] queue, int size) {
        int e = queue[--size];
        int index = 0;
        int half = size / 2;
        int child;
        int c;

        while (index < half) {
            child = index + index + 1;
            c = queue[child];
            if (child + 1 < size && !verifyOrder(c, queue[child + 1])) {
                c = queue[++child];
            }
            if (verifyOrder(e, c)) {
                break;
            }
            queue[index] = c;
            index = child;
        }
        queue[index] = e;
    }

    boolean verifyOrder(int a, int b) {
        return a <= b;
    }

    public static void main(String[] args) {
        int answer = new Solution().solution(new int[] { 3, 1, 2 }, 5);

        System.out.println(answer + ": " + (answer == 1));
    }
}