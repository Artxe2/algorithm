public class SegmentTree {
    public SegmentTree() {
        int length = 100000;
        long[] array = new long[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        printArray(array);

        long start = System.nanoTime();

        long[] segmentTree = segmentTree(array);
        int from = random.nextInt(length);
        int to = random.nextInt(length - from) + from;
        long sum = sum(segmentTree, length, from, to);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("segmentTree: " + time
                + "ms, sum " + from + " ~ " + to + ": " + sum);

        int value = length + random.nextInt(length);
        int index = from + random.nextInt(to - from + 1);

        update(segmentTree, length, index, value);
        sum = sum(segmentTree, length, from, to);

        System.out.println("update: " + index + " -> " + value + ", sum " + from + " ~ " + to + ": " + sum);

        printArray(segmentTree);
    }

    void printArray(long[] array) {
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
        new SegmentTree();
    }

    long[] segmentTree(long[] array) {
        int length = array.length;
        long[] segmentTree = new long[length * 4];

        init(array, segmentTree, 1, 0, length - 1);
        return segmentTree;
    }

    long init(long[] array, long[] tree, int node, int start, int end) {
        if (start == end) {
            return (tree[node] = array[start]);
        } else {
            int mid = (start + end) / 2;

            return (tree[node] = init(array, tree, node * 2, start, mid)
                    + init(array, tree, node * 2 + 1, mid + 1, end));
        }
    }

    long sum(long[] tree, int length, int sumStart, int sumEnd) {
        return sum(tree, 1, 0, length - 1, sumStart, sumEnd);
    }

    long sum(long[] tree, int node, int start, int end, int sumStart, int sumEnd) {
        if (start > sumEnd || end < sumStart) {
            return 0;
        }
        if (start >= sumStart && end <= sumEnd) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return sum(tree, node * 2, start, mid, sumStart, sumEnd)
                + sum(tree, node * 2 + 1, mid + 1, end, sumStart, sumEnd);
    }

    void update(long[] tree, int length, int index, int value) {
        update(tree, 1, 0, length - 1, index, value);
    }

    long update(long[] tree, int node, int start, int end, int index, int value) {
        if (start == end) {
            long diff = value - tree[node];

            tree[node] = value;
            return diff;
        }

        int mid = (start + end) / 2;
        long diff = index <= mid ? update(tree, node * 2, start, mid, index, value)
                : update(tree, node * 2 + 1, mid + 1, end, index, value);

        tree[node] += diff;
        return diff;
    }
}
