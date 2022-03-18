class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        int length = n + order.length - 1;
        int index = 0;
        int size = 1;
        int curr;
        int[] inDegree = new int[n];
        int[] from = new int[length];
        int[] to = new int[length];
        int[][] graph = toGraph(n, path);
        boolean[] visit = new boolean[n];
        java.util.Deque<Integer> rooms = new java.util.ArrayDeque<>(n);

        visit[0] = true;
        rooms.addLast(0);
        do {
            curr = rooms.pollFirst();
            for (int i : graph[curr]) {
                if (!visit[i]) {
                    visit[i] = true;
                    rooms.addLast(i);
                    from[index] = curr;
                    to[index++] = i;
                }
            }
            if (--size == 0) {
                size = rooms.size();
            }
        } while (!rooms.isEmpty());
        fill(inDegree, n, 1);
        for (int[] a : order) {
            from[index] = a[0];
            to[index++] = a[1];
            inDegree[a[1]]++;
        }
        topological(n, length, from, to, graph);
        if (inDegree[0] == 2) {
            return false;
        }
        rooms.addLast(0);
        for (int i = 1; i < n; i++) {
            curr = rooms.pollLast();
            for (int j : graph[curr]) {
                if (--inDegree[j] == 0) {
                    rooms.addLast(j);
                }
            }
            if (rooms.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    void topological(int n, int length, int[] from, int[] to, int[][] graph) {
        int f;
        int t;
        int[] visit = new int[n];

        for (int i : from) {
            visit[i]++;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[visit[i]];
        }
        fill(visit, n, 0);
        for (int i = 0; i < length; i++) {
            f = from[i];
            t = to[i];
            graph[f][visit[f]++] = t;
        }
    }

    int[][] toGraph(int n, int[][] path) {
        int a0;
        int a1;
        int[] visit = new int[n];
        int[][] graph = new int[n][];

        for (int[] a : path) {
            visit[a[0]]++;
            visit[a[1]]++;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[visit[i]];
        }
        fill(visit, n, 0);
        for (int[] a : path) {
            a0 = a[0];
            a1 = a[1];
            graph[a0][visit[a0]++] = a1;
            graph[a1][visit[a1]++] = a0;
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
}