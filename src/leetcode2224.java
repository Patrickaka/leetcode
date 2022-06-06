class Solution2224 {
    public int convertTime(String current, String correct) {
        int minutes1 = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
        int minutes2 = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));
        int ans = 0;
        int m = minutes2 - minutes1;
        if (m / 60 >= 1) {
            ans += m / 60;
            m = m % 60;
        }
        if (m / 15 >= 1) {
            ans += m / 15;
            m = m % 15;
        }
        if (m / 5 >= 1) {
            ans += m / 5;
            m = m % 5;
        }
        ans += m;
        return ans;
    }
}