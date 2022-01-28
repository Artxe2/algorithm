class Solution {
    public int solution(int[] info, int[][] edges) {
        int length = info.length;
        int answer = 0;
        int sheep = 0;
        int wolf = 0;
        int curr;
        int[][] graph = toGraph(length, edges);
        boolean[] visit = new boolean[length];
        java.util.Deque<Integer> sheeps = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> wolfs = new java.util.ArrayDeque<>();
        
        sheeps.add(0);
        while (!sheeps.isEmpty()) {
            answer++;
            sheep++;
            curr = sheeps.pop();
            visit[curr] = true;
            for (int i : graph[curr]) {
                if (!visit[i]) {
                    if (info[i] == 0) {
                        sheeps.add(i);
                    } else {
                        wolfs.add(i);
                    }
                }
            }
        }

        int count = answer;

        length = wolfs.size();
        if (length > 0 && answer > 1) {
            for (int i = 0; i < length; i++) {
                curr = wolfs.pop();
                answer = Math.max(answer,
                        tamingWolf(info, graph, count, sheep, wolf, curr, visit, sheeps, wolfs));
                wolfs.add(curr);
            }
        }
        return answer;
    }

    int tamingWolf(int[] info, int[][] graph, int count, int sheep, int wolf, int prev,
            boolean[] visit, java.util.Deque<Integer> sheeps, java.util.Deque<Integer> wolfs) {
        int answer = count;

        if (++wolf < sheep) {
            System.out.println(wolf + " < " + sheep);
            System.out.print(prev + ", ");
            System.out.println(wolfs);
            System.out.println();
            visit[prev] = true;
            for (int i : graph[prev]) {
                if (!visit[i]) {
                    if (info[i] == 0) {
                        sheeps.add(i);
                        answer = taming(info, graph, count, answer, sheep, wolf, prev, 
                                visit, sheeps, wolfs);
                    } else {
                        wolfs.add(i);
                        answer = taming(info, graph, count, answer, sheep, wolf, prev, 
                                visit, sheeps, wolfs);
                        wolfs.pop();
                    }
                }
            }
            visit[prev] = false;
        }
        return answer;
    }

    int tamingSheep(int[] info, int[][] graph, int count, int sheep, int wolf, int prev,
            boolean[] visit, java.util.Deque<Integer> sheeps, java.util.Deque<Integer> wolfs) {
        int answer = ++count;

        sheep++;
        visit[prev] = true;
        for (int i : graph[prev]) {
            if (!visit[i]) {
                if (info[i] == 0) {
                    sheeps.add(i);
                    answer = taming(info, graph, count, answer, sheep, wolf, prev, 
                            visit, sheeps, wolfs);
                } else {
                    wolfs.add(i);
                    answer = taming(info, graph, count, answer, sheep, wolf, prev, 
                            visit, sheeps, wolfs);
                    wolfs.pop();
                }
            }
        }
        visit[prev] = false;
        return answer;
    }

    int taming(int[] info, int[][] graph, int count, int answer, int sheep, int wolf, int prev,
            boolean[] visit, java.util.Deque<Integer> sheeps, java.util.Deque<Integer> wolfs) {
        if (!sheeps.isEmpty()) {
            int curr = sheeps.pop();

            answer = tamingSheep(info, graph, count, sheep, wolf, curr,
                    visit, sheeps, wolfs);
            sheeps.add(curr);
        } else if (!wolfs.isEmpty()) {
            int length = wolfs.size();

            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    int curr = wolfs.pop();

                    answer = Math.max(answer,
                            tamingWolf(info, graph, count, sheep, wolf, curr,
                                    visit, sheeps, wolfs));
                    wolfs.add(curr);
                }
            }
        }
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
        System.out.println("answer: " + new Solution().solution(
            new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new com.google.gson.Gson().fromJson(
                "[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]",
                int[][].class)));
        System.out.println("answer: " + new Solution().solution(
            new int[] {0,1,0,1,1,0,1,0,0,1,0}, new com.google.gson.Gson().fromJson(
                "[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]",
                int[][].class)));
    }
}