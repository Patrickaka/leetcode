package offer.offerII05;

class Solution {

    public int maxProduct(String[] words) {
        int ans = 0, n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int u = words[i].charAt(j) - 'a';
                t |= (1 << u);
            }
            mask[i] = t;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

}