```java
public class Backtracking {
    int answer;

    public Backtracking() {
        int length = 15;
        int valid = length;
        int[] array = new int[length];
        int[] sort = new int[length];
        boolean[] visit = new boolean[length];
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }

        long start = System.nanoTime();

        for (int i = 0; i < length; i++) {
            backtracking(array, visit, sort, length, valid, 0, i);
        }

        double time = (System.nanoTime() - start) / 1000000.0;

        System.out.println("answer: " + answer);
        System.out.println("dfs: " + time + "ms");
    }

    public static void main(String[] args) {
        new Backtracking();
    }

    int backtracking(int[] array, boolean[] visit, int[] sort,
            int length, int valid, int count, int index) {
        sort[count++] = array[index];
        if (count == length) {
            return verifyOrders(sort, length);
        }
        visit[index] = true;
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                valid = backtracking(array, visit, sort, length, valid, count, i);
                if (valid < count) {
                    break;
                } else {
                    valid = length;
                }
            }
        }
        visit[index] = false;
        return valid;
    }

    int verifyOrders(int[] sort, int length) {
        int prev = 0;

        for (int i = 0; i < length; i++) {
            if (prev > (prev = sort[i])) {
                return i;
            }
        }
        answer++;
        return length;
    }
}
```