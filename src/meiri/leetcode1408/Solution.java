package meiri.leetcode1408;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (words[j].indexOf(words[i]) > 0) {
                        result.add(words[i]);
                        break;
                    }
                }
            }
        }
        return result;
    }
}