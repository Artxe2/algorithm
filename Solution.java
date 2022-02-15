class Solution {
    class Trie {
        int value;
        java.util.Map<Character, Trie> map = new java.util.HashMap<>();

        Trie get(char key) {
            return map.get(key);
        }

        int value() {
            return value;
        }

        void putPrefix(String s, int length, int index) {
            this.value++;
            if (index < length) {
                map.computeIfAbsent(s.charAt(index++), 
                        key -> new Trie()).putPrefix(s, length, index);
            }
        }

        void putSuffix(String s, int index) {
            this.value++;
            if (index-- > 0) {
                map.computeIfAbsent(s.charAt(index),
                        key -> new Trie()).putSuffix(s, index);
            }
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int range = 10001;
        int qLength = queries.length;
        int length;
        int index;
        int[] answer = new int[qLength];
        char c;
        String query;
        Trie trie;
        Trie[] prefixTries = new Trie[range];
        Trie[] suffixTries = new Trie[range];

        for (int i = 0; i < range; i++) {
            prefixTries[i] = new Trie();
            suffixTries[i] = new Trie();
        }
        for (String s : words) {
            length = s.length();
            prefixTries[length].putPrefix(s, length, 0);
            suffixTries[length].putSuffix(s, length);
        }
        for (int i = 0; i < qLength; i++) {
            query = queries[i];
            length = query.length();
            if ((c = query.charAt(0)) != '?') {
                trie = prefixTries[length];
                index = 1;
                trie = trie.get(c);
                while (trie != null && index < length
                        && (c = query.charAt(index++)) != '?') {
                    trie = trie.get(c);
                }
            } else if ((c = query.charAt(length - 1)) != '?') {
                trie = suffixTries[length];
                index = length - 1;
                trie = trie.get(c);
                while (trie != null && index > 0
                        && (c = query.charAt(--index)) != '?') {
                    trie = trie.get(c);
                }
            } else {
                trie = prefixTries[length];
            }
            if (trie != null) {
                answer[i] = trie.value();
            }
        }
        return answer;
    }
}