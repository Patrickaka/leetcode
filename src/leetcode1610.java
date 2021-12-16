import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        double pi = Math.PI;
        double t = angle * pi / 180;
        int ans = 0, coincide = 0;
        int length = points.size();
        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                coincide++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) + pi);
        }
        Collections.sort(angles);

        return ans;
    }
}