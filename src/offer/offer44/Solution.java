package offer.offer44;

/**
 * 数字序列中某一位的数字
 */
class Solution {

    /**
     * @param n 第n位
     * @return 第n位的数字
     */
    public int findNthDigit(int n) {
        int len = 1;
        // len * 9 * Math.pow(10, len - 1) 为所有长度为len的数字的长度和
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= (len * 9 * Math.pow(10, len - 1));
            len++;
        }
        //得到所求数的长度为len
        //s为长度为len的数的最小值
        //x为所求的数
        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / Math.pow(10, len - n) % 10);
    }
}