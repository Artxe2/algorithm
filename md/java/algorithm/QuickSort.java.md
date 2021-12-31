```java
public class QuickSort {
    int compare;

    public QuickSort() {
        int length = 1000000;
        int[] array = new int[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        printArray(array);

        long start = System.nanoTime();

        quickSort(array, 0, array.length);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("quickSort: " + time
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
        new QuickSort();
    }

    void quickSort(int[] array, int start, int end) {
        if (end - start > 1) {
            int left = start;
            int right = end;
            int mid = (start + end) / 2;
            int pivot = array[mid];

            array[mid] = array[start];
            left = partition(array, left, right, pivot);
            quickSort(array, start, left);
            quickSort(array, left + 1, end);
        }
    }

    int partition(int[] array, int left, int right, int pivot) {
        while (left < right) {
            while (left < right && verifyOrder(pivot, array[--right]));
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && verifyOrder(array[++left], pivot));
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[right] = pivot;
        return left;
    }

    boolean verifyOrder(int a, int b) {
        compare++;
        return a <= b;
    }
}
```