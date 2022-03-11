public class Main {
    public static void main(String[] args) {
        int[] a = { 1,1,1,1,1,1,2,5,8,2,1,1,4,8,8,8,12,6,6 };
        int[] b = { 4,3,1,5,6 };
        int[] answer = new Solution().solution(a, b);

        System.out.println("answer: " + Gson.toJson(answer) + " == [6,3,1,5,9]: " + Gson.toJson(answer).equals("[6,3,1,5,9]"));
    }
}
