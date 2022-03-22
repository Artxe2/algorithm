public class Main {
    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(
            new String[] { "go","gone","guild" }
        );
        System.out.println("answer: " + answer + " == 7 ? " + (answer == 7));

        answer = new Solution().solution(
            new String[] { "abc","def","ghi","jklm" }
        );
        System.out.println("answer: " + answer + " == 4 ? " + (answer == 4));

        answer = new Solution().solution(
            new String[] { "word","war","warrior","world" }
        );
        System.out.println("answer: " + answer + " == 15 ? " + (answer == 15));
    }
}
