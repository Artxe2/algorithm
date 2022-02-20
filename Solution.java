class Solution {
    public int solution(int n, int m, int[][] timetable) {
        int size = 0;
        int max = 1;
        int a0;
        int a1;
        int[] queue = new int[n * n];

        mergeSort(timetable);
        for (int [] a : timetable) {
            a0 = a[0];
            a1 = a[1];
            while (size > 0 && peek(queue) < a0) {
                poll(queue, size--);
            }
            add(queue, size++, a1);
            max = Math.max(max, size);
        }
        if (max == 1) {
            return 0;
        }
        if (max < 5) {
            return (n - 1) * 4 / max;
        }
        if (max > n * n / 2 + (max % 2 > 0 ? 1 : 0)) {
            return 1;
        }

        int start = 2;
        int mid;
        int end = n - 2;

        while (start < end) {
            mid = (start + end + 1) / 2;
            if (getMax(n, mid) <= max) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    int getMax(int n, int mid) {
        int a = (n - 1) / mid + 1;
        int x = mid / 2;
        int y = mid - x;
        int b = (n - 1) % mid;
        System.out.println(a + ", " + x + ", " + y + ", " + b);
        return 10;
    }

    int poll(int[] queue, int size) {
        int result = queue[0];

        shiftDown(queue, 0, size);
        return result;
    }

    void shiftDown(int[] queue, int start, int end) {
        System.arraycopy(queue, start + 1, queue, start, end - start);
    }

    void add(int[] queue, int size, int e) {
        if (size == 0) {
            queue[0] = e;
        } else {
            int index = findIndex(queue, e, 0, size);

            shiftUp(queue, index, size);
            queue[index] = e;
        }
    }

    int findIndex(int[] queue, int e, int start, int end) {
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

    void shiftUp(int[] queue, int start, int end) {
        System.arraycopy(queue, start, queue, start + 1, end - start);
    }

    int peek(int[] queue) {
        return queue[0];
    }

    void mergeSort(int[][] array) {
        int[][] memory = new int[array.length / 2 + 1][];

        mergeSort(array, memory, 0, array.length);
    }

    void mergeSort(int[][] array, int[][] memory, int start, int end) {
        int mid = end - start;

        if (mid > 2) {
            mid = (start + end + 1) / 2;
            mergeSort(array, memory, start, mid);
            mergeSort(array, memory, mid, end);
            merge(array, memory, start, mid, end);
        } else if (mid > 1) {
            int[] a = array[start];
            int[] b = array[--end];

            if (!verifyOrder(a, b)) {
                array[start] = b;
                array[end] = a;
            }
        }
    }

    void merge(int[][] array, int[][] memory, int start, int mid, int end) {
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

    boolean verifyOrder(int[] a, int[] b) {
        return a[0] <= b[0];
    }

    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(4, 5, Gson.fromJson(int[][].class, "[[1150,1200],[1150,1200],[1140,1200],[1150,1200],[1100,1200],[1210,1300],[1220,1280],[1140,1200],[1150,1200],[1100,1200],[1210,1300],[1220,1280]]"));
        System.out.println(answer + " == 2: " + (answer == 2));
    
        System.out.println(new Solution().getMax(10, 4));
    }
}