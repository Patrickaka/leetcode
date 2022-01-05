class Solution {
    public String modifyString(String s) {
        char[] ans = s.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                replaced(ans, i);
            }
        }
        return String.valueOf(ans);
    }

    private void replaced(char[] s, int index) {
        char a = index == 0 ? '?' : s[index - 1];
        char b = index == s.length - 1 ? '?' : s[index + 1];
        for (int i = 0; i < 24; i++) {
            if ('a' + i != a && 'a' + i != b) {
                s[index] = (char) ('a' + i);
                break;
            }
        }
    }
}