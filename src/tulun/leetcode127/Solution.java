package tulun.leetcode127;

import java.util.*;

/**
 * 双向bfs
 */
class Solution {

    Set<String> set;

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("cog");
        words.add("dog");
        words.add("lot");
        words.add("log");
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, words));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>(wordList);
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        d1.addLast(beginWord);
        map1.put(beginWord, 0);
        if (set.contains(endWord)) {
            d2.addLast(endWord);
            map2.put(endWord, 0);
        }
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int ans;
            if (d1.size() <= d2.size()) {
                ans = update(d1, map1, map2);
            } else {
                ans = update(d2, map2, map1);
            }
            if (ans != 0) {
                return ans;
            }
        }
        return 0;
    }

    int update(Deque<String> deque, Map<String, Integer> source, Map<String, Integer> target) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            String str = deque.pollFirst();
            int step = source.get(str);
            for (int j = 0; j < str.length(); j++) {
                char c = 'a' - 1;
                for (int k = 0; k < 26; k++) {
                    c++;
                    if (c != str.charAt(j)) {
                        String s = str.substring(0, j) + c + str.substring(j + 1);
                        if (!set.contains(s)) {
                            continue;
                        }
                        if (target.containsKey(s)) {
                            return target.get(s) + step + 2;
                        }
                        if (!source.containsKey(s)) {
                            deque.add(s);
                            source.put(s, step + 1);
                        }
                    }
                }
            }
        }
        return 0;
    }
}