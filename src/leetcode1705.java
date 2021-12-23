class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        int n = apples.length;
        int[] eating = new int[40005];
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            if (apples[i] == 0) {
                continue;
            }
            maxDay = i + 1 + apples[i] - 1;
            for (int j = 1; j < maxDay; j++) {
                if (eating[j] == 0) {
                    ans++;
                }
                eating[i]++;
            }
        }
        return ans;
    }
}