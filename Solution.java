class Solution {
    public int solution(int[] a) {
        int length = a.length;
        int answer = 0;
        int [] count = new int[length--];

        for (int i : a) {
            count[i]++;
        }
        for (int i = 0; i <= length; i++) {
            if (count[i] > answer) {
                answer = Math.max(answer, countingStar(a, length, i));
            }
        }
        return answer * 2;
    }

    int countingStar(int[] a, int length, int star) {
        int index = 0;
        int count = 0;
        
        while (index < length) {
            if (a[index++] == star) {
                if (a[index] != star) {
                    count++;
                    index++;
                }
            } else if (a[index] == star) {
                count++;
                index++;
            }
        }
        return count;
    }
}