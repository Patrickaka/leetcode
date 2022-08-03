package meiri;

class Solution507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int max = (int) Math.sqrt(num);
        int ans = 1;
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                int temp = i + num / i;
                ans += temp;
            }
        }
        return ans == num;
    }
}