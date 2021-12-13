import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] temp = s.toCharArray();
        Map<Character, Integer> count = new HashMap<>();
        int max = 0, num = 0, end = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = end; j < temp.length; j++) {
                if (count.get(temp[j]) != null && count.get(temp[j]) == 1) {
                    count.clear();
                    if (num > max) {
                        max = num;
                    }
                    num = 0;
                    end = j - 1;
                    break;
                }
                count.put(temp[j], 1);
                num++;
            }
        }
        if (num > max) {
            max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "jbpnbwwd";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}