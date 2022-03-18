public class Main {
    public static void main(String[] args) {
        boolean answer;

        answer = new Solution().solution(
            9
            , Gson.fromJson(int[][].class, "[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]")
            , Gson.fromJson(int[][].class, "[[8,5],[6,7],[4,1]]")
        );
        System.out.println("answer: " + answer + " == true ?");
        
        answer = new Solution().solution(
            9
            , Gson.fromJson(int[][].class, "[[8,1],[0,1],[1,2],[0,7],[4,7],[0,3],[7,5],[3,6]]")
            , Gson.fromJson(int[][].class, "[[4,1],[5,2]]")
        );
        System.out.println("answer: " + answer + " == true ?");
        
        answer = new Solution().solution(
            9
            , Gson.fromJson(int[][].class, "[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]")
            , Gson.fromJson(int[][].class, "[[4,1],[8,7],[6,5]]")
        );
        System.out.println("answer: " + answer + " == false ?");
    }
}
