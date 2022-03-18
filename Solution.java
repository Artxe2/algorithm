class Solution {
    public int solution(int n, int[][] data) {
        int size = 0;
        int index = 0;
        int prev = -1;
        int curr;
        int[] queue = new int[n];
        java.util.Map<Integer, Integer> yIndex = new java.util.HashMap<>();
        java.util.Map<Integer, Integer> xIndex = new java.util.HashMap<>();

        for (int[] a : data) {
            offer(queue, size++, a[0]);
        }
        for (int i = 0; i < n; i++) {
            curr = poll(queue, size--);
            if (curr > prev) {
                yIndex.put(curr, index++);
                prev = curr;
            }
        }
        index = 0;
        prev = -1;
        for (int[] a : data) {
            offer(queue, size++, a[1]);
        }
        for (int i = 0; i < n; i++) {
            curr = poll(queue, size--);
            if (curr > prev) {
                xIndex.put(curr, index++);
                prev = curr;
            }
        }

        int yLength = yIndex.size();
        int xLength = xIndex.size();
        boolean[][] matrix = new boolean[yLength][xLength];

        for (int[] a : data) {
            matrix[yIndex.get(a[0])][xIndex.get(a[1])] = true;
        }
        for (int i = 1; i < yLength; i++) {
            size += countTent(matrix[i - 1], matrix[i], xLength);
        }
        return size;
    }

    int countTent(boolean[] a, boolean[] b, int length) {
        int index = 0;

        while (index < length) {
            
        }
        return length;
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
            child = index * 2 + 1;
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
}