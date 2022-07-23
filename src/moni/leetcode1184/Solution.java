package moni.leetcode1184;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 1;
        System.out.println(s.distanceBetweenBusStops(distance, start, destination));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + distance[i - 1];
        }
        int min = Math.min(start, destination), max = Math.max(start, destination);
        int l1 = sum[max] - sum[min];
        int l2 = (sum[n] - sum[max]) + (sum[min]);
        return Math.min(l1, l2);
    }
}