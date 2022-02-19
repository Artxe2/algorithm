class Solution {
    public long[] solution(long k, long[] room_number) {
        int index = 0;
        java.util.Map<Long, Long> map = new java.util.HashMap<>();

        for (long l : room_number) {
            room_number[index++] = find(map, l);
        }
        return room_number;
    }

    long find(java.util.Map<Long, Long> map, long room) {
        if (map.containsKey(room)) {
            long next = find(map, map.get(room));

            map.put(room, next + 1);
            return next;
        } else {
            map.put(room, room + 1);
            return room;
        }
    }
}