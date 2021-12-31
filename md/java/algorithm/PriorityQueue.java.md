```java
public class PriorityQueue {
    int compare;

    public PriorityQueue() {
        int length = 1000000;
        int size = 0;
        int[] array = new int[length];
        int[] queue = new int[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        printArray(array);

        long start = System.nanoTime();

        for (int i : array) {
            offer(queue, size++, i);
        }

        double time = (System.nanoTime() - start) / 1000000.0;

        for (int i = 0; i < length; i++) {
            array[i] = poll(queue, size--);
        }

        double time2 = (System.nanoTime() - start) / 1000000.0;

        System.out.println("priorityQueue: " + time + "ms");
        System.out.println("heapSort: " + time2
                + "ms\n\t, compare: " + String.format("%,d", compare));
        printArray(array);
    }

    void printArray(int[] array) {
        int length = array.length;
        System.out.print("{ ");
        if (length < 25) {
            for (int i = 0; i < length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
        } else {
            for (int i = 0; i < 10 - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[10] + " ... ");
            for (int i = length - 10; i < length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print(array[length - 1] + " }\n");
    }

    public static void main(String[] args) {
        new PriorityQueue();
    }

    void heapSort(int[] array, int length) {
        int size = 0;
        int[] queue = new int[length];

        for (int i : array) {
            offer(queue, size++, i);
        }
        for (int i = 0; i < length; i++) {
            array[i] = poll(queue, size--);
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
        compare++;
        return a <= b;
    }
}
```