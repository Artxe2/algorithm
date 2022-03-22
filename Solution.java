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

        void put(String s, int length, int index) {
            this.value++;
            if (index < length) {
                int i = s.charAt(index++) - 97;
                Trie t = child[i];

                if (t == null) {
                    t = new Trie();
                    child[i] = t;
                }
                t.put(s, length, index);
            }
        }
    }

    public int solution(String[] words) {
        int answer = 0;
        int length;
        int index;
        Trie root = new Trie();
        Trie trie;

        for (String s : words) {
            root.put(s, s.length(), 0);
        }
        for (String s : words) {
            length = s.length();
            index = 0;
            trie = root;
            while (index < length) {
                trie = trie.get(s.charAt(index++) - 97);
                if (trie.value() == 1) {
                    break;
                }
            }
            answer += index;
        }
        return answer;
    }
}