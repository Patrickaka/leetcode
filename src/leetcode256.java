class Solution256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int a = 0, b = 0, c = 0;
        for (int[] cost : costs) {
            int d = Math.min(b, c) + cost[0];
            int e = Math.min(a, c) + cost[1];
            int f = Math.min(a, b) + cost[2];
            a = d;
            b = e;
            c = f;
        }
        return Math.min(a, Math.min(b, c));
    }
}