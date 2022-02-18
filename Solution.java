class Solution {
    public long[] solution(long k, long[] room_number) {
        int length = room_number.length;
        int size = 0;
        long[] queue = new long[length];
        long[] answer = new long[length];

        for (int i = 0; i < length; i++) {
            answer[i] = add(queue, size++, room_number[i]);
        }
        return answer;
    }

    long add(long[] queue, int size, long e) {
        if (size == 0) {
            queue[0] = e;
        } else {
            int index = findIndex(queue, e, 0, size);

            if (index > 0 && e == queue[index - 1]) {
                index = findGap(queue, e, index - 1, size);
                e = queue[index - 1] + 1;
            }
            shiftUp(queue, index, size);
            queue[index] = e;
        }
        return e;
    }

    int findIndex(long[] queue, long e, int start, int end) {
        int mid;

        while (start < end) {
            mid = (start + end - 1) / 2;
            if (queue[mid] <= e) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    int findGap(long[] queue, long e, int start, int end) {
        int mid;

        while (start < end) {
            mid = (start + end + 1) / 2;
            if (queue[mid] == 0 || mid - start < queue[mid] - queue[start]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start + 1;
    }

    void shiftUp(long[] queue, int start, int end) {
        System.arraycopy(queue, start, queue, start + 1, end - start);
    }
}