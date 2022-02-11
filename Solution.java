class Solution {
    public int[] solution(String[] words, String[] queries) {
        int length = queries.length;
        int[] answer = new int[length];
        String s;
        String[] surfix = words.clone();

        mergeSort(words, surfix);
        for (int i = 0; i < length; i++) {
            s = queries[i];
            if (s.charAt(0) == '?') {
                answer[i] = countValidSuffix(surfix, s);
            } else {
                answer[i] = countValidPrefix(words, s);
            }
        }
        return answer;
    }

    int countValidPrefix(String[] prefix, String query) {
        int length = query.length();
        int count = 0;
        int index;

        for (int i = 0; i < length; i++) {
            
        }
        return count;
    }

    int countValidSuffix(String[] surfix, String query) {
        int count = 0;

        return count;
    }

    boolean verifyOrderPrefix() {
        return false;
    }

    boolean verifyOrderSuffix() {
        return false;
    }

    void mergeSort(String[] prefix, String[] suffix) {
        int length = prefix.length;
        String[] memory = new String[length / 2 + 1];

        mergeSort(prefix, memory, 0, length);
        mergeReverseSort(suffix, memory, 0, length);
    }

    void mergeSort(String[] array, String[] memory, int start, int end) {
        int mid = end - start;

        if (mid > 2) {
            mid = (start + end + 1) / 2;
            mergeSort(array, memory, start, mid);
            mergeSort(array, memory, mid, end);
            merge(array, memory, start, mid, end);
        } else if (mid > 1) {
            String a = array[start];
            String b = array[--end];

            if (!verifyOrder(a, b)) {
                array[start] = b;
                array[end] = a;
            }
        }
    }

    void merge(String[] array, String[] memory, int start, int mid, int end) {
        int a = mid - start;
        int b = end - mid;

        if (a <= b) {
            int i = 0;
            int j = mid;

            System.arraycopy(array, start, memory, 0, a);
            for (;;) {
                if (verifyOrder(memory[i], array[j])) {
                    array[start++] = memory[i++];
                    if (i == a) {
                        break;
                    }
                } else {
                    array[start++] = array[j++];
                    if (j == end) {
                        System.arraycopy(memory, i, array, start, end - start);
                        break;
                    }
                }
            }
        } else {
            int i = b - 1;
            int j = mid - 1;

            System.arraycopy(array, mid, memory, 0, b);
            for (;;) {
                if (verifyOrder(array[j], memory[i])) {
                    array[--end] = memory[i--];
                    if (i < 0) {
                        break;
                    }
                } else {
                    array[--end] = array[j--];
                    if (j < start) {
                        System.arraycopy(memory, 0, array, start, i + 1);
                        break;
                    }
                }
            }
        }
    }

    boolean verifyOrder(String a, String b) {
        int length = Math.min(a.length(), b.length());

        for (int i = 0; i < length; i++) {
            if (a.charAt(i) < b.charAt(i)) {
                return true;
            }
            if (a.charAt(i) > b.charAt(i)) {
                return false;
            }
        }
        return a.length() <= b.length();
    }

    void mergeReverseSort(String[] array, String[] memory, int start, int end) {
        int mid = end - start;

        if (mid > 2) {
            mid = (start + end + 1) / 2;
            mergeReverseSort(array, memory, start, mid);
            mergeReverseSort(array, memory, mid, end);
            mergeReverse(array, memory, start, mid, end);
        } else if (mid > 1) {
            String a = array[start];
            String b = array[--end];

            if (!verifyReverseOrder(a, b)) {
                array[start] = b;
                array[end] = a;
            }
        }
    }

    void mergeReverse(String[] array, String[] memory, int start, int mid, int end) {
        int a = mid - start;
        int b = end - mid;

        if (a <= b) {
            int i = 0;
            int j = mid;

            System.arraycopy(array, start, memory, 0, a);
            for (;;) {
                if (verifyReverseOrder(memory[i], array[j])) {
                    array[start++] = memory[i++];
                    if (i == a) {
                        break;
                    }
                } else {
                    array[start++] = array[j++];
                    if (j == end) {
                        System.arraycopy(memory, i, array, start, end - start);
                        break;
                    }
                }
            }
        } else {
            int i = b - 1;
            int j = mid - 1;

            System.arraycopy(array, mid, memory, 0, b);
            for (;;) {
                if (verifyReverseOrder(array[j], memory[i])) {
                    array[--end] = memory[i--];
                    if (i < 0) {
                        break;
                    }
                } else {
                    array[--end] = array[j--];
                    if (j < start) {
                        System.arraycopy(memory, 0, array, start, i + 1);
                        break;
                    }
                }
            }
        }
    }

    boolean verifyReverseOrder(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int length = Math.min(aLength, bLength);

        for (int i = 1; i <= length; i++) {
            if (a.charAt(aLength - i) < b.charAt(bLength - i)) {
                return true;
            }
            if (a.charAt(aLength - i) > b.charAt(bLength - i)) {
                return false;
            }
        }
        return aLength <= bLength;
    }

    public static void main(String[] args) {
        PrintArray.print(new Solution().solution(
                new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
                new String[] { "fro??", "????o", "fr???", "fro???", "pro?" }));
    }
}