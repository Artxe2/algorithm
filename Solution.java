class Solution {
    public int solution(int[] sales, int[][] links) {
        int length = sales.length;
        int index = 0;
        int a0;
        int a1;
        int rt;
        int sumChild;
        int attendCost;
        int[] work = new int[length];
        boolean[] visit = new boolean[length];
        java.util.Deque<Integer> queue = new java.util.ArrayDeque<>();
        java.util.Map<Integer, Integer> leaders = new java.util.HashMap<>();
        java.util.Map<Integer, java.util.Deque<Integer>> teams = 
                new java.util.HashMap<>();

        for (int[] a : links) {
            a0 = a[0] - 1;
            a1 = a[1] - 1;
            leaders.put(a1, a0);
            teams.computeIfAbsent(a0, key -> new java.util.ArrayDeque<>()).add(a1);
        }

        int tLength = teams.size();
        int[] root = new int[tLength];

        for (int i = 0; i < length; i++) {
            if (teams.get(i) == null) {
                visit[i] = true;
            }
        }
        queue.addLast(0);
        do {
            rt = queue.pollFirst();
            root[index++] = rt;
            for (int i : teams.get(rt)) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.addLast(i);
                }
            }
        } while (index < tLength);
        do {
            rt = root[--index];
            queue = teams.get(rt);
            sumChild = 0;
            attendCost = 10000;
            for (int i : queue) {
                a0 = work[i];
                a1 = sales[i];
                sumChild += Math.min(a0, a1);
                attendCost = Math.min(attendCost, a1 - a0);
            }
            sales[rt] += sumChild;
            if (attendCost > 0) {
                sumChild += attendCost;
            }
            work[rt] += sumChild;
        } while (index > 0);
        return Math.min(sales[0], work[0]);
    }
}