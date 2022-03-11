```java
public class Dijkstra {
    int size = 1;

    public Dijkstra() {
        int n = 1000000;
        int index = 0;
        int[][] edges = new int[n * 4][];
        java.util.Random random = new java.util.Random();

        do {
            edges[index] = new int[] { index++, index, random.nextInt(n) + 1 };
        } while (index + 1 < n);
        do {
            int a = random.nextInt(n);
            int b = random.nextInt(n * 2 / 3);
            int c = a - n / 3 + b;

            while (c == a || c < 0 || c >= n) {
                b = random.nextInt(n * 2 / 3);
                c = a - n / 3 + b;
            }
            edges[index++] = new int[] { a, c, random.nextInt(n) + 1 };
        } while (index < n * 4);

        int s = 0;
        int e = n - 1;

        long start = System.nanoTime();

        long answer = dijkstra(n, edges, s, e);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("dijkstra: " + time
                + "ms\n\t, " + s + " -> " + e + ": " + String.format("%,d", answer));
    }

    public static void main(String[] args) {
        new Dijkstra();
    }

    long dijkstra(int n, int[][] edges, int start, int end) {
        int max = Integer.MAX_VALUE;
        int[][] graph = toGraph(n, edges);
        int[] queue = new int[n];
        int[] time = new int[n];
        boolean[] visit = new boolean[n];

        fill(time, n, max);
        time[start] = 0;
        queue[0] = start;
        while (connect(graph, time, queue, end, max, visit));
        return time[end];
    }

    boolean connect(int[][] graph, int[] time, int[] queue,
            int end, int max, boolean[] visit) {
        int from = 0;
        int min = max;

        while (size > 0) {
            from = poll(queue, size--, time);
            if (!visit[from]) {
                min = time[from];
                break;
            }
        }
        visit[from] = true;
        if (from == end) {
            time[end] = min;
            return false;
        }

        int index = 0;
        int to;
        int cost;
        int[] temp;

        temp = graph[from];
        while (index < temp.length) {
            to = temp[index++];
            cost = temp[index++];
            if (!visit[to] && cost + min < time[to]) {
                time[to] = cost + min;
                offer(queue, size++, to, time);
            }
        }
        return true;
    }

    int[] dijkstra(int n, int s, int k, int[][] cost, boolean[] visit) {
        int[] fare = new int[n];

        visit[s] = true;
        System.arraycopy(cost[s], 0, fare, 0, n);
        fare[s] = 0;
        while (connect(n, k, fare, cost, visit));
        return fare;
    }

    boolean connect(int n, int k, int[] fare, int[][] cost, boolean[] visit) {
        int index = 0;
        int min = k;
        int t;
        int[] temp;

        for (int i = 0; i < n; i++) {
            if (!visit[i] && fare[i] < min) {
                index = i;
                min = fare[i];
            }
        }
        if (min == k) {
            return false;
        }
        visit[index] = true;
        temp = cost[index];
        for (int i = 0; i < n; i++) {
            t = temp[i];
            if (!visit[i] && t + min < fare[i]) {
                fare[i] = t + min;
            }
        }
        return true;
    }

    int[][] toGraph(int n, int[][] roads) {
        int a0;
        int a1;
        int a2;
        int[] visit = new int[n];
        int[][] graph = new int[n][];

        for (int[] a : roads) {
            visit[a[0]] += 2;
            visit[a[1]] += 2;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[visit[i]];
        }
        fill(visit, n, 0);
        for (int[] a : roads) {
            a0 = a[0];
            a1 = a[1];
            a2 = a[2];
            graph[a0][visit[a0]++] = a1;
            graph[a0][visit[a0]++] = a2;
        }
        return graph;
    }

    void fill(int[] array, int length, int value) {
        int index = 1;

        array[0] = value;
        do {
            System.arraycopy(array, 0, array, index, index);
            index += index;
        } while (index * 2 < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }

    void offer(int[] queue, int size, int e, int[] time) {
        if (size == 0) {
            queue[0] = e;
        } else {
            siftUp(queue, size, e, time);
        }
    }

    int poll(int[] queue, int size, int[] time) {
        int result = queue[0];

        siftDown(queue, size, time);
        return result;
    }

    void siftUp(int[] queue, int size, int e, int[] time) {
        int parent;
        int p;

        while (size > 0) {
            parent = (size - 1) / 2;
            p = queue[parent];
            if (verifyOrder(p, e, time)) {
                break;
            }
            queue[size] = p;
            size = parent;
        }
        queue[size] = e;
    }

    void siftDown(int[] queue, int size, int[] time) {
        int e = queue[--size];
        int index = 0;
        int half = size / 2;
        int child;
        int c;

        while (index < half) {
            child = index * 2 + 1;
            c = queue[child];
            if (child + 1 < size && !verifyOrder(c, queue[child + 1], time)) {
                c = queue[++child];
            }
            if (verifyOrder(e, c, time)) {
                break;
            }
            queue[index] = c;
            index = child;
        }
        queue[index] = e;
    }

    boolean verifyOrder(int a, int b, int[] time) {
        return time[a] <= time[b];
    }
}
```