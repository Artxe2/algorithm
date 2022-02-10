```java
class BoyerMoore {
    public BoyerMoore() {
        java.util.Random random = new java.util.Random();

        char[] valueStr = new char[10000000];
        for (int i = 0; i < valueStr.length; i++) {
            valueStr[i] = (char) ('a' + random.nextInt(6));
        }
        char[] patternStr = new char[6 + random.nextInt(6)];
        for (int i = 0; i < patternStr.length; i++) {
            patternStr[i] = (char) ('a' + random.nextInt(4));
        }

        long start = System.nanoTime();

        int count = boyerMoore(valueStr, patternStr);

        double time = (System.nanoTime() - start) / 1000000.0;

        int jCount = javaIndexOf(valueStr, patternStr);

        System.out.println("boyerMoore: " + time + "ms, count: "
                + count + " == " + jCount);
        System.out.println("pattern: " + new String(patternStr));
    }

    int javaIndexOf(char[] valueStr, char[] patternStr) {
        int vLength = valueStr.length;
        int pLength = patternStr.length;

        if (pLength == 0 || vLength < pLength) {
            return 0;
        }

        String value = new String(valueStr);
        String pattern = new String(patternStr);
        int count = 0;
        int index = value.indexOf(pattern);

        while (index >= 0) {
            count++;
            index = value.indexOf(pattern, index + pLength);
        }
        return count;
    }

    public static void main(String[] args) {
        new BoyerMoore();
    }

    int boyerMoore(char[] valueStr, char[] patternStr) {
        int vLength = valueStr.length;
        int pLength = patternStr.length;

        if (pLength == 0 || vLength < pLength) {
            return 0;
        }

        int badCharacter[] = makeBadCharacter(patternStr, pLength);
        int goodSuffix[] = makeGoodSuffix(patternStr, pLength);
        int count = 0;
        int index = indexOf(valueStr, patternStr, vLength, pLength, 0,
                badCharacter, goodSuffix);

        while (index >= 0) {
            count++;
            index = indexOf(valueStr, patternStr, vLength, pLength, index + pLength,
                    badCharacter, goodSuffix);
        }
        return count;
    }

    int indexOf(char[] valueStr, char[] patternStr, 
            int vLength, int pLength, int start,
            int badCharacter[], int goodSuffix[]) {
        start += pLength - 1;
        if (start < vLength) {
            int v;
            int s;

            do {
                v = start;
                s = pLength - 1;
                while (valueStr[v] == patternStr[s]) {
                    if (s-- == 0) {
                        return v;
                    }
                    v--;
                }
                start = Math.max(v + badCharacter[valueStr[v]], start + goodSuffix[s]);
            } while (start < vLength);
        }
        return -1;
    }

    int[] makeBadCharacter(char[] patternStr, int pLength) {
        int index = 0;
        int[] table = new int[123];

        fill(table, 123, pLength);
        do {
            table[patternStr[index++]] = pLength - index;
        } while (index < pLength);
        return table;
    }

    int[] makeGoodSuffix(char[] patternStr, int pLength) {
        int index = 1;
        int[] table = new int[pLength];

        fill(table, index, 1);
        while (++index < pLength) {
            table[index - 1] = repeatOf(patternStr, index, pLength);
        }
        table[index - 1] = 1;
        return table;
    }

    int repeatOf(char[] patternStr, int index, int pLength) {
        int ref = index - 1;

        do {
            if (isRepeat(patternStr, pLength, ref, index)) {
                return index - ref;
            }
        } while (--ref >= 0);
        return 1;
    }

    boolean isRepeat(char[] patternStr, int pLength, int i, int j) {
        do {
            if (patternStr[i++] != patternStr[j++]) {
                return false;
            }
        } while (j < pLength);
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
}
```