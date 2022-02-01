class Solution {
    public int solution(int[] info, int[][] edges) {
        int length = info.length;
        int answer = 0;
        int sheep = 0;
        int wolf = 1;
        int curr;
        int[][] graph = toGraph(length, edges);
        boolean[] visit = new boolean[length];
        java.util.Deque<Integer> sheeps = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> wolfs = new java.util.ArrayDeque<>();
        
        sheeps.add(0);
        do {
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
        } while (!sheeps.isEmpty());
        
        int count = answer;

        length = wolfs.size();
        if (length > 0 && answer > 1) {
            for (int i = 0; i < length; i++) {
                curr = wolfs.pop();
                answer = Math.max(answer,
                        backtracking(info, graph, count, sheep, wolf, curr, 
                                visit, sheeps, wolfs));
                wolfs.add(curr);
            }
        }
        return answer;
    }

    int backtracking(int[] info, int[][] graph,
            int answer, int sheep, int wolf, int prev,
            boolean[] visit, java.util.Deque<Integer> sheeps,
            java.util.Deque<Integer> wolfs) {
        int curr;
        int s = 0;
        int w = 0;

        visit[prev] = true;
        for (int i : graph[prev]) {
            if (!visit[i]) {
                if (info[i] == 0) {
                    sheeps.add(i);
                    s++;
                } else {
                    wolfs.add(i);
                    w++;
                }
            }
        }

        int count = answer;
        int length = wolfs.size();

        if (!sheeps.isEmpty()) {
            curr = sheeps.pop();
            answer = Math.max(answer,
                    backtracking(info, graph, count + 1, sheep + 1, wolf, curr, 
                            visit, sheeps, wolfs));
            if (s > 1) {
                sheeps.pollLast();
            }
        } else if (length > 0 && answer > ++wolf) {
            for (int i = 0; i < length; i++) {
                curr = wolfs.pop();
                answer = Math.max(answer,
                        backtracking(info, graph, count, sheep, wolf, curr, 
                                visit, sheeps, wolfs));
                wolfs.add(curr);
            }
        }
        for (int i = 0; i < w; i++) {
            wolfs.pollLast();
        }
        visit[prev] = false;
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
}