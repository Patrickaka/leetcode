package meiri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1610 {
    static double eps = 1e-9;

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int x = location.get(0), y = location.get(1);
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for (List<Integer> p : points) {
            int a = p.get(0), b = p.get(1);
            if (a == x && b == y && ++cnt >= 0) continue;
            list.add(Math.atan2(b - y, a - x) + pi);
        }
        Collections.sort(list);
        int n = list.size(), max = 0;
        for (int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for (int i = 0, j = 0; j < 2 * n; j++) {
            while (i < j && list.get(j) - list.get(i) > t + eps) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }


    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list2.add(2);
        list2.add(2);
        list3.add(3);
        list3.add(4);
        list4.add(1);
        list4.add(1);
        points.add(list1);
        points.add(list2);
        points.add(list3);
        points.add(list4);
        int angle = 90;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        int ans = visiblePoints(points, angle, location);
        System.out.println(ans);
    }
}