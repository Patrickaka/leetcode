class Solution1037 {
    public boolean isBoomerang(int[][] ps) {
        return (ps[1][0] - ps[0][0]) * (ps[2][1] - ps[0][1]) != (ps[2][0] - ps[0][0]) * (ps[1][1] - ps[0][1]);
    }
}
