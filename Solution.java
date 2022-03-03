class Solution {
    public int solution(int[] sales, int[][] links) {
        int length = 0;
        int answer = 0;
        int[] supervisors = new int[sales.length];
        boolean[] visit = new boolean[sales.length];

        for (int[] a : links) {
            supervisors[a[1] - 1] = a[0] - 1;
        }
        for (int i : supervisors) {
            if (!visit[i]) {
                visit[i] = true;
                length++;
            }
        }

        int[] team = new int[length];

        for (int i : supervisors) {
            if (visit[i]) {
                visit[i] = false;
                team[--length] = i;
            }
        }
        PrintArray.print(team);
        return dfs();
    }

    int dfs() {
        return 0;
    }
}