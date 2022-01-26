class Solution {
    public int solution(int[] info, int[][] edges) {
        int length = info.length;
        int answer = 1;
        int sheep = 1;
        int wolf = 0;
        int[][] graph = toGraph(length, edges);
        java.util.Deque<Integer> wolfs = new java.util.ArrayDeque<>();

        return answer;
    }

    int[][] toGraph(int length, int[][] edges) {
        int a0;
        int a1;
        int[] visit = new int[length];
        int[][] graph = new int[length][];

        for (int[] a : edges) {
            visit[a[0]]++;
            visit[a[1]]++;
        }
        for (int i = 0; i < length; i++) {
            graph[i] = new int[visit[i]];
        }
        fill(visit, length, 0);
        for (int[] a : edges) {
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
        } while (index + index < length);
        if (index < length) {
            System.arraycopy(array, 0, array, index, length - index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new com.google.gson.Gson().fromJson("[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]", int[][].class)));
    }
}