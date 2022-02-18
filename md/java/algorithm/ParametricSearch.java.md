```java
public class ParametricSearch {
    public ParametricSearch() {
        int length = 10000;
        int[] array = new int[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        java.util.Arrays.sort(array);
        printArray(array);

        long start = System.nanoTime();

        int el = random.nextInt(length);
        int min = findMin(array, length);
        int max = findMax(array, length);
        int index = findIndex(array, length, el);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println(el + " index: " + index);
        System.out.println("parametricSearch: " + time + "ms");
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
        new ParametricSearch();
    }

    int findMin(int[] array, int length) {
        int start = 0;
        int mid;
        int end = length * length;

        while (start < end) {
            mid = (start + end - 1) / 2;

            int acc = 0;

            for (int i : array) {
                acc += i;
            }
            if (acc <= mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    int findMax(int[] array, int length) {
        int start = 0;
        int mid;
        int end = length - 1;

        while (start < end) {
            mid = (start + end + 1) / 2;
            if (mid <= array[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    int findIndex(int[] array, int length, int el) {
        int start = 0;
        int mid;
        int end = length - 1;

        while (start < end) {
            mid = (start + end - 1) / 2;
            if (array[mid] <= el) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
```