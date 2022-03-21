public class Main {
    public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        int answer;

        answer = new Solution().solution(
            4
            , Gson.fromJson(int[][].class, "[[0, 0], [3, 4], [0, 8], [6, 0]]")
        );
        System.out.println("answer: " + answer + " == 3 ? " + (answer == 3));

        int length = 10;
        boolean[] a = new boolean[length];
        boolean[] b = new boolean[length];

        for (int i = 0; i < length; i++) {
            a[i] = r.nextInt(2) > 0;
            b[i] = r.nextInt(2) > 0;
        }
    }
}
