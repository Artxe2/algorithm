public class Main {
    public static void main(String[] args) {
        int[] answer;

        answer = new Solution().solution(1, 10);
        System.out.println("answer: " + Gson.toJson(answer)
                + " == [0,1,1,2,1,3,1,4,3,5] ? "
                + Gson.toJson(answer).equals("[0,1,1,2,1,3,1,4,3,5]")
        );
        // answer = new Solution().solution(49, 55);
        // System.out.println("answer: " + Gson.toJson(answer)
        //         + " == [9009009,10000000] ? "
        //         + Gson.toJson(answer).equals("[9009009,10000000]")
        // );
    }
}
