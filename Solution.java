class Solution {
    class Trie {
        int index;
        int length;
        java.util.Map<Character, Trie> map = new java.util.HashMap<>();
        java.util.Set<String> set = new java.util.HashSet<>();

        Trie(int index, int length) {
            this.index = index + 1;
            this.length = length;
        }

        void copySetToMap() {
            int index = this.index;
            int length = this.length;
            char c;
            java.util.Map<Character, Trie> map = this.map;

            for (String s : set) {
                c = s.charAt(index);
                map.computeIfAbsent(c, key -> new Trie(index, length)).set.add(s);
            }
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int length = queries.length;
        int sLength;
        int[] answer = new int[length];
        Trie[] tries = new Trie[10];
        java.util.Set<String> set = new java.util.HashSet<>();

        for (int i = 4; i < 7; i++) {
            tries[i] = new Trie(-1, i);
        }
        for (String s : words) {
            tries[s.length()].set.add(s);
        }
        for (Trie t : tries) {
            if (t != null) {
                t.copySetToMap();
            }
        }
        System.out.println(Gson.toJson(tries));
        return answer;
    }

    public static void main(String[] args) {
        PrintArray.print(new Solution().solution(
                new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
                new String[] { "fro??", "????o", "fr???", "fro???", "pro?" }));
    }
}