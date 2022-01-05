class Solution {
    public static int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {
        int n = 4;
        int ans = lastRemaining(n);
        System.out.println(ans);
    }
}
