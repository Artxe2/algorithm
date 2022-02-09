```java
class BoyerMoore {
    public BoyerMoore() {
        java.util.Random random = new java.util.Random();

        char[] valueStr = new char[10000000];
        for (int i = 0; i < valueStr.length; i++) {
            valueStr[i] = (char) ('a' + random.nextInt(26));
        }
        char[] searchStr = new char[4 + random.nextInt(4)];
        for (int i = 0; i < searchStr.length; i++) {
            searchStr[i] = (char) ('a' + random.nextInt(26));
        }

        long start = System.nanoTime();

        int count = boyerMoore(valueStr, searchStr);

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("boyerMoore: " + time
                + "ms { target: " + new String(searchStr) + ", count: " + count + " }");
    }

    public static void main(String[] args) {
        new BoyerMoore();
    }

    int boyerMoore(char[] valueStr, char[] searchStr) {
        int vLength = valueStr.length;
        int sLength = searchStr.length;

        if (sLength == 0 || vLength < sLength) {
            return 0;
        }

        int badCharacter[] = makeBadCharacter(searchStr, sLength);
        int goodSuffix[] = makeGoodSuffix(searchStr, sLength);
        int count = 0;
        int index = indexOf(valueStr, searchStr, vLength, sLength, 0,
                badCharacter, goodSuffix);

        while (index >= 0) {
            count++;
            index = indexOf(valueStr, searchStr, vLength, sLength, index + sLength,
                    badCharacter, goodSuffix);
        }
        return count;
    }

    int indexOf(char[] valueStr, char[] searchStr, int vLength, int sLength, int start,
            int badCharacter[], int goodSuffix[]) {
        start += sLength - 1;
        if (start < vLength) {
            int v;
            int s;

            do {
                v = start;
                s = sLength - 1;
                while (valueStr[v] == searchStr[s]) {
                    if (s-- == 0) {
                        return v;
                    }
                    v--;
                }
                start += Math.max(badCharacter[valueStr[v]], goodSuffix[s]);
            } while (start < vLength);
        }
        return -1;
    }

    int[] makeBadCharacter(char[] searchStr, int sLength) {
        int index = 0;
        int[] table = new int[123];

        fill(table, 123, sLength);
        do {
            table[searchStr[index++]] = sLength - index;
        } while (index < sLength);
        return table;
    }

    int[] makeGoodSuffix(char[] searchStr, int sLength) {
        int index = (sLength - 1) / 2;
        int ref;
        int[] table = new int[sLength];

        fill(table, sLength, 1);
        while (++index < sLength) {
            ref = repeatOf(searchStr, index, sLength);
            if (ref >= 0) {
                table[index - 1] = index - ref;
            }
        }
        return table;
    }

    int repeatOf(char[] searchStr, int index, int sLength) {
        int ref = index - (sLength - index);

        do {
            if (isRepeat(searchStr, sLength, ref, index)) {
                return ref;
            }
        } while (--ref >= 0);
        return -1;
    }

    boolean isRepeat(char[] searchStr, int sLength, int i, int j) {
        do {
            if (searchStr[i++] != searchStr[j++]) {
                return false;
            }
        } while (j < sLength);
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