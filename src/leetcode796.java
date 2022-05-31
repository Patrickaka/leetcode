class Solution796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        String temp = s;
        for (int i = 0; i < n; i++) {
            temp = temp.substring(1, n) + temp.charAt(0);
            if (temp.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}