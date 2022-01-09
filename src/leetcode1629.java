class Solution1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] >= maxTime) {
                if (releaseTimes[i] - releaseTimes[i - 1] == maxTime && keysPressed.charAt(i) <= ans) {
                    continue;
                }
                maxTime = releaseTimes[i] - releaseTimes[i - 1];
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}