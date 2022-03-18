public class Main {
    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(
            4
            , Gson.fromJson(int[][].class, "[[0, 0], [3, 4], [0, 8], [6, 0]]")
        );
        System.out.println("answer: " + answer + " == 3 ? " + (answer == 3));
    }
}
