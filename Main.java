public class Main {
    public static void main(String[] args) {
        int answer;

        answer = new Solution().solution(6, new int[] { 1, 2, 3 });
        System.out.println(answer + " == 2: " + (answer == 2));

        answer = new Solution().solution(2, new int[] { 1, 2, 3 });
        System.out.println(answer + " == 2: " + (answer == 2));

        answer = new Solution().solution(1203, new int[] { 50, 50, 50, 30 });
        System.out.println(answer + " == 4: " + (answer == 4));
    }
}
