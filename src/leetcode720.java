import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord1(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : set) {
            if (word.length() < ans.length()) {
                continue;
            }
            if (word.length() == ans.length() && word.compareTo(ans) > 0) {
                continue;
            }
            for (int i = 0; i < word.length(); i++) {
                if (i == word.length() - 1) {
                    ans = word;
                    break;
                }
                if (!set.contains(word.substring(0, i + 1))) {
                    break;
                }
            }
        }
        return ans;
    }

    public String longestWord(String[] words) {
        String ans = "";

        return ans;
    }
}