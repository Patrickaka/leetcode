package zhousai.danzhou309.t1;

class Solution {

    public boolean checkDistances(String s, int[] distance) {
        boolean[] vis = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (!vis[u]) {
                vis[u] = true;
                int t = distance[u];
                if (s.charAt(i) != s.charAt(i + t + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}