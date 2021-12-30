```java
public class MergeSort {
    int compare;

    public MergeSort() {
        int length = 1000000;
        int[] array = new int[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        printArray(array);

        long start = System.nanoTime();

        mergeSort(array);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("merge sort: " + time
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
        new MergeSort();
    }

    void mergeSort(int[] array) {
        int[] memory = new int[array.length / 2 + 1];

        mergeSort(array, memory, 0, array.length);
    }

    void mergeSort(int[] array, int[] memory, int start, int end) {
        int mid = end - start;

        if (mid > 2) {
            mid = (start + end + 1) / 2;
            mergeSort(array, memory, start, mid);
            mergeSort(array, memory, mid, end);
            merge(array, memory, start, mid, end);
        } else if (mid > 1) {
            int a = array[start];
            int b = array[--end];

            if (!verifyOrder(a, b)) {
                array[start] = b;
                array[end] = a;
            }
        }
    }

    void merge(int[] array, int[] memory, int start, int mid, int end) {
        int a = mid - start;
        int b = end - mid;

        if (a <= b) {
            int i = 0;
            int j = mid;

            System.arraycopy(array, start, memory, 0, a);
            for (;;) {
                if (verifyOrder(memory[i], array[j])) {
                    array[start++] = memory[i++];
                    if (i == a) {
                        break;
                    }
                } else {
                    array[start++] = array[j++];
                    if (j == end) {
                        System.arraycopy(memory, i, array, start, end - start);
                        break;
                    }
                }
            }
        } else {
            int i = b - 1;
            int j = mid - 1;

            System.arraycopy(array, mid, memory, 0, b);
            for (;;) {
                if (verifyOrder(array[j], memory[i])) {
                    array[--end] = memory[i--];
                    if (i < 0) {
                        break;
                    }
                } else {
                    array[--end] = array[j--];
                    if (j < start) {
                        System.arraycopy(memory, 0, array, start, i + 1);
                        break;
                    }
                }
            }
        }
    }

    boolean verifyOrder(int a, int b) {
        compare++;
        return a <= b;
    }
}
```