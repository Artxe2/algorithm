class Solution {
    public int solution(int n, int[] cores) {
        int length = cores.length;

        quickSort(cores, 0, length);

        int start = 1;
        int mid;
        int end = n * cores[length - 1] / cores.length;
        int work;

        while (start < end) {
            mid = (start + end + 1) / 2;
            remove = 0;
            previous = 0;
            for (int i = 0; i < length; i++) {
                if (rocks[i] - previous < mid) {
                    remove++;
                } else {
                    previous = rocks[i];
                }
            }
            if (distance - previous < mid) {
                remove++;
            }
            if (n >= remove) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
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
            while (left < right && pivot <= array[--right]);
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[++left] <= pivot);
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[right] = pivot;
        return left;
    }
}