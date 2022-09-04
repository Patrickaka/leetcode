package zhousai.danzhou304.t2;

class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int ans = 1;
        while (ans <= n) {
            n -= ans;
            ans++;
        }
        return ans - 1;
    }
}