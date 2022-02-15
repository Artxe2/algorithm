class Solution {
    class Trie {
        int value;
        Trie[] child = new Trie[26];

        Trie get(int i) {
            return child[i];
        }

        int value() {
            return value;
        }

        void putPrefix(String s, int length, int index) {
            this.value++;
            if (index < length) {
                int i = s.charAt(index++) - 97;
                Trie t = child[i];

                if (t == null) {
                    t = new Trie();
                }
                child[i] = t;
                t.putPrefix(s, length, index);
            }
        }

        void putSuffix(String s, int index) {
            this.value++;
            if (index-- > 0) {
                int i = s.charAt(index) - 97;
                Trie t = child[i];

                if (t == null) {
                    t = new Trie();
                }
                child[i] = t;
                t.putSuffix(s, index);
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
                trie = trie.get(c - 97);
                while (trie != null && index < length
                        && (c = query.charAt(index++)) != '?') {
                    trie = trie.get(c - 97);
                }
            } else if ((c = query.charAt(length - 1)) != '?') {
                trie = suffixTries[length];
                index = length - 1;
                trie = trie.get(c - 97);
                while (trie != null && index > 0
                        && (c = query.charAt(--index)) != '?') {
                    trie = trie.get(c - 97);
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

    public static void main(String[] args) {
        PrintArray.print(new Solution().solution(
                new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
                new String[] { "fro??", "????o", "fr???", "fro???", "pro?" }));
    }
}