package meiri;

class Solution1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int max = 0, temp = 0;
        for (char c : chars) {
            if (c == '(') {
                temp++;
                max = Math.max(max, temp);
            } else if (c == ')') {
                temp--;
            }
        }
        return max;
    }
}