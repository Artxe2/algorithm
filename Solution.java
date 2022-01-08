class Solution {
    public int[] solution(int[] arr, int divisor) {
        int length = 0;

        for (int i : arr) {
            if (i % divisor == 0) {
                arr[length++] = i;
            }
        }
        if (length == 0) {
            return new int[] { -1 };
        }
        java.util.Arrays.sort(arr, 0, length);

        int[] answer = new int[length];

        System.arraycopy(arr, 0, answer, 0, length);
        return answer;
    }
}