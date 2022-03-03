public class Main {
    public static void main(String[] args) {
        int[] sales = Gson.fromJson(int[].class, "[14, 17, 15, 18, 19, 14, 13, 16, 28, 17]");
        int[][] links = Gson.fromJson(int[][].class, "[[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]");

        int answer = new Solution().solution(sales, links);

        System.out.println("answer: " + answer + " == 44: " + (answer == 44));
    }
}
