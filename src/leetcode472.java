import java.util.*;

class Solution472 {
    Set<Long> wordsSet = new HashSet<>();
    final int P = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            long hash = 0;
            for (char c : word.toCharArray()) {
                hash = hash * P + (c - 'a') + OFFSET;
            }
            wordsSet.add(hash);
        }
        for (String word : words) {
            if (check(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean check(String word) {
        int n = word.length();
        int[] temp = new int[n + 1];
        Arrays.fill(temp, -1);
        temp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (temp[i] == -1) {
                continue;
            }
            long cur = 0;
            for (int j = i + 1; j <= n; j++) {
                cur = cur * P + (word.charAt(j - 1) - 'a') + OFFSET;
                if (wordsSet.contains(cur)) {
                    temp[j] = Math.max(temp[j], temp[i] + 1);
                }
            }
            if (temp[n] > 1) {
                return true;
            }
        }
        return false;
    }
}