class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = w + 1;
        int interval = w * 2 + 1;

        for (int i : stations) {
            while (index < i) {
                System.out.println(index + " < " + i);
                index += interval;
                answer++;
            }
            index = i + interval;
        }
        index -= w + 1;
        while (index < n) {
            System.out.println(index + " < " + n);
            index += interval;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int answer = new Solution().solution(17, new int[] { 9 }, 2);
        
        System.out.println(answer);
    }
}