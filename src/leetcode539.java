import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution539 {
    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size() + 1];
        Arrays.fill(times,10000);
        int i = 0, ans = 10000;
        for (String s : timePoints) {
            int time = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
            times[i++] = time;
        }
        Arrays.sort(times);
        times[i] = times[0] + 24 * 60;
        for (i = 0; i < timePoints.size(); i++) {
            int temp = times[i + 1] - times[i];
            if (temp < ans) {
                ans = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("01:01");
        timePoints.add("02:01");
        timePoints.add("03:00");
        timePoints.add("03:01");
        int ans = findMinDifference(timePoints);
        System.out.println(ans);
    }
}