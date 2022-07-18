public class Main {
    
    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(
            new int[][] { { 5, 3 }, { 3, 10 }, { 10, 6 } }
        );
        System.out.println("answer: " + answer + " == 270");
    }
}
