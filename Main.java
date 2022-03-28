public class Main {
    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(
            new int[] { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 }
            , Gson.fromJson(int[][].class, "[[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]")
        );
        System.out.println("answer: " + answer + " == 44 ? " + (answer == 44));

        answer = new Solution().solution(
            new int[] { 5, 6, 5, 3, 4 }
            , Gson.fromJson(int[][].class, "[[2,3], [1,4], [2,5], [1,2]]")
        );
        System.out.println("answer: " + answer + " == 6 ? " + (answer == 6));

        answer = new Solution().solution(
            new int[] { 5, 6, 5, 1, 4 }
            , Gson.fromJson(int[][].class, "[[2,3], [1,4], [2,5], [1,2]]")
        );
        System.out.println("answer: " + answer + " == 5 ? " + (answer == 5));

        answer = new Solution().solution(
            new int[] { 10, 10, 1, 1 }
            , Gson.fromJson(int[][].class, "[[3,2], [4,3], [1,4]]")
        );
        System.out.println("answer: " + answer + " == 2 ? " + (answer == 2));
    }
}
