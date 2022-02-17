class Solution {
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int k = 1001;
        int bit = 1;
        int[] trapBit = new int[k];
        int[][] graph = toGraph(n, roads);

        for (int i = 0; i < traps.length; i++) {
            trapBit[--traps[i]] = bit;
            bit *= 2;
        }

        int bitLength = n * bit;
        int[] time = new int[bitLength];
        boolean[] visit = new boolean[bitLength];

        fill(time, bitLength, k);
        time[--start] = 0;
        while (connect(n, k, time, graph, visit, trapBit, bitLength));
        for (int i = --end; i < bitLength; i += n) {
            k = Math.min(k, time[i]);
        }
        return k;
    }

    boolean connect(int n, int k, int[] time, int[][] graph, boolean[] visit,
            int[] trapBit, int bitLength) {
        int from = 0;
        int min = k;

        for (int i = 0; i < bitLength; i++) {
            if (!visit[i] && time[i] < min) {
                from = i;
                min = time[i];
            }
        }
        if (min == k) {
            return false;
        }

        int bit = from / n;
        int nb;
        int index = 0;
        int to;
        int cost;
        int[] temp;

        visit[from] = true;
        from %= n;
        temp = graph[from];
        while (index < temp.length) {
            to = temp[index++];
            cost = temp[index++];
            cost = getCost(k, trapBit, bit, from, to, cost);
            nb = n * (bit ^ trapBit[to]);
            if (!visit[nb + to] && cost + min < time[nb + to]) {
                time[nb + to] = cost + min;
            }
        }
        return true;
    }

    int getCost(int k, int[] trapBit, int bit, int from, int to, int cost) {
        boolean a = (trapBit[from] & bit) > 0;
        boolean b = (trapBit[to] & bit) > 0;
        int result = a && b || !a && !b ? cost : -cost;

        return result > 0 ? result : k;
    }

    int[][] toGraph(int n, int[][] roads) {
        int a0;
        int a1;
        int a2;
        int[] visit = new int[n];
        int[][] graph = new int[n][];

        for (int[] a : roads) {
            visit[--a[0]] += 2;
            visit[--a[1]] += 2;
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
            graph[a1][visit[a1]++] = a0;
            graph[a1][visit[a1]++] = -a2;
        }
        return graph;
    }

    void fill(int[] array, int length, int value) {
        int index = 1;

        array[0] = value;
        do {
            System.arraycopy(array, 0, array, index, index);
            index += index;
        } while (index + index < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }

    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(3, 1, 3,
                Gson.fromJson(int[][].class, "[[1, 2, 2], [3, 2, 3]]"),
                new int[] { 2 });
        System.out.println(answer + " == " + 5 + ": " + (answer == 5));

        answer = new Solution().solution(4, 1, 4,
                Gson.fromJson(int[][].class, "[[1, 2, 1], [3, 2, 1], [2, 4, 1]]"),
                new int[] { 2, 3 });
        System.out.println(answer + " == " + 4 + ": " + (answer == 4));
    }
}