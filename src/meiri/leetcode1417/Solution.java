package meiri.leetcode1417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums.add(Integer.parseInt(String.valueOf(c)));
            } else if (c >= 'a' && c <= 'z') {
                chars.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int l1 = chars.size(), l2 = nums.size();
        if (Math.abs(l1 - l2) > 1) {
            return "";
        } else if (l1 >= l2) {
            for (int i = 0; i < l2; i++) {
                sb.append(chars.get(i));
                sb.append(nums.get(i));
            }
            if (l1 > l2) {
                sb.append(chars.get(l1 - 1));
            }
        } else {
            for (int i = 0; i < l1; i++) {
                sb.append(nums.get(i));
                sb.append(chars.get(i));
            }
            sb.append(nums.get(l2 - 1));
        }
        return sb.toString();
    }
}