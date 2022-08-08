package offer.offer10I;

class Solution {

    int MOD = (int) 1e9 + 7;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        long prev1 = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            long temp = prev2;
            prev2 = (prev1 + prev2) % MOD;
            prev1 = temp;
        }
        return (int) (prev2 % MOD);
    }
}