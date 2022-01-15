class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int size = 0;
        int time;
        int number;
        int fee;
        java.util.Map<Integer, Integer> in = new java.util.HashMap<>();
        java.util.Map<Integer, Integer> total = new java.util.HashMap<>();

        for (String s : records) {
            time = (s.charAt(0) - 48) * 600 + (s.charAt(1) - 48) * 60
                    + (s.charAt(3) - 48) * 10 + s.charAt(4) - 48;
            number = (s.charAt(6) - 48) * 1000 + (s.charAt(7) - 48) * 100
                    + (s.charAt(8) - 48) * 10 + s.charAt(9) - 48;
            if (s.charAt(11) == 'I') {
                in.put(number, time);
            } else {
                time -= in.remove(number);
                total.put(number, total.getOrDefault(number, 0) + time);
            }
        }
        for (java.util.Map.Entry<Integer, Integer> e : in.entrySet()) {
            time = 1439 - e.getValue();
            number = e.getKey();
            total.put(number, total.getOrDefault(number, 0) + time);
        }

        int length = total.size();
        int[] answer = new int[length];

        for (int i : total.keySet()) {
            offer(answer, size++, i);
        }
        for (int i = 0; i < length; i++) {
            time = total.get(answer[i]) - baseTime;
            if (time > 0) {
                fee = time / unitTime * unitFee;
                if (time % unitTime > 0) {
                    fee += unitFee;
                }
            } else {
                fee = 0;
            }
            answer[i] = baseFee + fee;
        }
        return answer;
    }

    void offer(int[] queue, int size, int e) {
        if (size == 0) {
            queue[0] = e;
        } else {
            int index = findIndex(queue, e, 0, size);

            shiftUp(queue, index, size);
            queue[index] = e;
        }
    }

    void shiftUp(int[] queue, int start, int end) {
        while (end > start) {
            queue[end--] = queue[end];
        }
    }

    int findIndex(int[] queue, int e, int start, int end) {
        int mid;

        /* parametric search */
        while (start < end) {
            mid = (start + end - 1) / 2;
            if (queue[mid] <= e) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        PrintArray.print(new Solution().solution(
            new int[] { 180, 5000, 10, 600 },
            new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" }));
    }
}