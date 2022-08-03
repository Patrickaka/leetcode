package meiri;

class Solution1716 {
    public static int totalMoney(int n) {
        int[] money = {0, 1, 2, 3, 4, 5, 6, 7};
        int weeks = n / 7;
        int days = n % 7;
        int ans = 0, cnt = 0;
        for (int i = 1; i <= weeks; i++) {
            ans += 28 + 7 * cnt++;
        }
        for (int i = 1; i <= days; i++) {
            ans += money[i] + cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 20;
        int ans = totalMoney(n);
        System.out.println(ans);
    }
}