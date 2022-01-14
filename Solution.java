class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int length = id_list.length;
        int space;
        int user;
        int target;
        int[] count = new int[length];
        int[] answer = new int[length];
        java.util.Map<String, Integer> index = new java.util.HashMap<>();
        java.util.Map<Integer, java.util.Set<Integer>> map = new java.util.HashMap<>();

        for (int i = 0; i < length; i++) {
            index.put(id_list[i], i);
        }
        for (String s : report) {
            space = s.indexOf(' ');
            user = index.get(s.substring(0, space));
            target = index.get(s.substring(space + 1, s.length()));
            if (map.computeIfAbsent(target, key -> new java.util.HashSet<>()).add(user)) {
                count[target]++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (count[i] >= k) {
                for (int j : map.get(i)) {
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PrintArray.print(new Solution().solution(
            new String[] { "muzi", "frodo", "apeach", "neo" }, 
            new String[] { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" },
            2));
    }
}