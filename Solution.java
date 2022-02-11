class Solution {
    public int solution(String[] strs, String t) {
        int overflow = 20001;
        int sLength = strs.length;
        int length = t.length();
        int count;
        int[] answer = new int[length + 1];
        char[] target = t.toCharArray();
        char[][] pieces = new char[sLength][];

        fill(answer, length + 1, overflow);
        for (int i = 0; i < sLength; i++) {
            pieces[i] = strs[i].toCharArray();
        }
        answer[0] = 0;
        for (int i = 0; i < length; i++) {
            count = answer[i];
            if (count++ < overflow) {
                for (char[] p : pieces) {
                    if (verifyPiece(target, p, length, i)) {
                        answer[i + p.length] = Math.min(answer[i + p.length], count);
                    }
                }
            }
        }
        PrintArray.print(answer);
        return answer[length] < overflow ? answer[length] : -1;
    }

    boolean verifyPiece(char[] target, char[] piece, int length, int index) {
        if (index + piece.length > length) {
            return false;
        }
        for (char c : piece) {
            if (target[index++] != c) {
                return false;
            }
        }
        return true;
    }

    void fill(int[] array, int length, int value) {
        int index = 1;

        array[0] = value;
        if (length > 1) {
            do {
                System.arraycopy(array, 0, array, index, index);
                index += index;
            } while (index * 2 < length);
            if (index < length) {
                System.arraycopy(array, 0, array, index, length - index);
            }
        }
    }

    public static void main(String[] args) {
        int answer;
        
        answer = new Solution().solution(
                new String[] { "ba","na","n","a" },	"banana");
        System.out.println(answer + ": " + (answer == 3));

        answer = new Solution().solution(
                new String[] { "app","ap","p","l","e","ple","pp" },	"apple");
        System.out.println(answer + ": " + (answer == 2));

        answer = new Solution().solution(
                new String[] { "ba","an","nan","ban","n" },	"banana");
        System.out.println(answer + ": " + (answer == -1));
    }
}