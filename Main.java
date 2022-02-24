public class Main {
    public static void main(String[] args) {
        // int answer;

        // answer = new Solution().solution(3, 2, Gson.fromJson(int[][].class,
        //     "[[1170,1210], [1200,1260]]"));
        // System.out.println(answer + " == 4: " + (answer == 4));

        // answer = new Solution().solution(2, 1, Gson.fromJson(int[][].class,
        //     "[[840,900]]"));
        // System.out.println(answer + " == 0: " + (answer == 0));

        // answer = new Solution().solution(2, 2, Gson.fromJson(int[][].class,
        //     "[[600,630],[630,700]]"));
        // System.out.println(answer + " == 2: " + (answer == 2));

        // answer = new Solution().solution(4, 5, Gson.fromJson(int[][].class,
        //     "[[1140,1200],[1150,1200],[1100,1200],[1210,1300],[1220,1280]]"));
        // System.out.println(answer + " == 4: " + (answer == 4));
        
        // int n = 8;
        // System.out.println("countMax: " + new Solution().countMax(n, 3, n * n, new boolean[n * n]));

        int[] cust = { 600, 1320 };
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i * i; j++) {
                int[][] timetable = new int[j][];
                for (int k = 0; k < j; k++) {
                    timetable[k] = cust;
                }
                System.out.println(i + ": " + j + ":: " + 
                        new Solution().solution(i, j, timetable));
            }
            System.out.println();
        }
    }
}
