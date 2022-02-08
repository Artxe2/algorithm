class BoyerMoore {
    public BoyerMoore() {
        java.util.Random random = new java.util.Random();

        char[] haystack = new char[1000000];
        for (int i = 0; i < haystack.length; i++) {
            haystack[i] = (char) ('a' + random.nextInt(26));
        }
        char[] needle = new char[4];
        for (int i = 0; i < needle.length; i++) {
            needle[i] = (char) ('a' + random.nextInt(26));
        }

        long start = System.nanoTime();

        int count = boyerMoore(haystack, needle);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("boyerMoore: " + time
                + "ms { target: " + new String(needle) + ", count: " + count + " }");
    }

    public static void main(String[] args) {
        new BoyerMoore();
    }

    int boyerMoore(char[] haystack, char[] needle) {
        int hLength = haystack.length;
        int nLength = needle.length;
        int charTable[] = makeCharTable(needle, nLength);
        int offsetTable[] = makeOffsetTable(needle, nLength);
        int index = indexOf(haystack, needle, hLength, nLength, charTable, offsetTable);

        while (index >= 0) {
            index += nLength;
        }
        return index;
    }

    int indexOf(char[] haystack, char[] needle, int hLength, int nLength,
            int charTable[], int offsetTable[]) {
        for (int i = nLength - 1, j; i < hLength;) {
            for (j = nLength - 1; needle[j] == haystack[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(offsetTable[nLength - 1 - j], charTable[haystack[i]]);
        }
        return -1;
    }

    int[] makeCharTable(char[] needle, int length) {
        int[] table = new int[123];

        fill(table, 123, length);
        for (int i = 0; i < length; ++i) {
            table[needle[i]] = length - 1 - i;
        }
        return table;
    }

    int[] makeOffsetTable(char[] needle, int length) {
        int lastPrefixPosition = length;
        int slen;
        int[] table = new int[length];

        for (int i = length; i > 0; --i) {
            if (isPrefix(needle, length, i)) {
                lastPrefixPosition = i;
            }
            table[length - i] = lastPrefixPosition - i + length;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    boolean isPrefix(char[] needle, int length, int p) {
        for (int i = p, j = 0; i < length; ++i, ++j) {
            if (needle[i] != needle[j]) {
                return false;
            }
        }
        return true;
    }

    int suffixLength(char[] needle, int p) {
        int len = 0;
        
        for (int i = p, j = needle.length - 1;
                 i >= 0 && needle[i] == needle[j]; --i, --j) {
            len += 1;
        }
        return len;
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
}