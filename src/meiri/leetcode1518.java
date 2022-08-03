package meiri;

class Solution1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int temp = numBottles;
        while (numBottles / numExchange != 0) {
            ans += temp;
            temp = numBottles / numExchange;
            numBottles -= temp * numExchange;
            numBottles += temp;
        }
        ans += temp;
        return ans;
    }

    public static void main(String[] args) {
        int numBottles = 15, numExchange = 4;
        int ans = numWaterBottles(numBottles, numExchange);
        System.out.println(ans);
    }
}