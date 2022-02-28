public class SegmentTree {
    public SegmentTree() {
        int length = 30;
        int[] array = new int[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        printArray(array);

        long start = System.nanoTime();

        int[] segmentTree = segmentTree(array);
        int from = random.nextInt(length);
        int to = random.nextInt(length - from) + from;
        int sum = sum(segmentTree, length, from, to);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("segmentTree: " + time
                + "ms, sum " + from + " ~ " + to + ": " + sum);
        printArray(segmentTree);
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
        new SegmentTree();
    }

    int[] segmentTree(int[] array) {
        int length = array.length;
        int[] segmentTree = new int[length * 4];

        init(array, segmentTree, 1, 0, length - 1);
        return segmentTree;
    }

    int init(int[] array, int[] tree, int node, int start, int end) {
        if (start == end) {
            return (tree[node] = array[start]);
        } else {
            int mid = (start + end) / 2;

            return (tree[node] = init(array, tree, node * 2, start, mid)
                    + init(array, tree, node * 2 + 1, mid + 1, end));
        }
    }

    int sum(int[] tree, int length, int sumStart, int sumEnd) {
        return sum(tree, 1, 0, length - 1, sumStart, sumEnd);
    }

    int sum(int[] tree, int node, int start, int end, int sumStart, int sumEnd) {
        if (start > sumEnd || end < sumStart) {
            System.out.println(start + " ~ " + end + ": " + 0);
            return 0;
        }
        if (start >= sumStart && end <= sumEnd) {
            System.out.println(start + " ~ " + end + ": " + tree[node]);
            return tree[node];
        }

        int mid = (start + end) / 2;

        return sum(tree, node * 2, start, mid, sumStart, sumEnd)
                + sum(tree, node * 2 + 1, mid + 1, end, sumStart, sumEnd);
    }

    void update(int[] tree, int index, int value) {
        // https://www.acmicpc.net/blog/view/9
    }
}
