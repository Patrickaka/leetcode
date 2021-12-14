import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0], e = c[1];
            sum += d;
            q.add(d);
            if (sum > e) {
                sum -= q.poll();
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int ans = scheduleCourse(courses);
        System.out.println(ans);
    }
}