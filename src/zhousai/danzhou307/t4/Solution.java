package zhousai.danzhou307.t4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    /**
     * 找出数组的第 K 大和
     * 参考本题的简化问题 给定 nn 个非负数 a1,a2,a3,...an  求第k个最小的子序列和
     * 然后用所有数字的总和减去第k个最小子序列和就是第k个最大子序列和
     * 首先将所有数字排序，利用小根堆，记（s, i）是一个和为s，以i结尾的子序列
     * 每次取出堆内元素时可以有两种操作：
     * 1. 将i+1加入子序列
     * 2. 将i换成i+1加入子序列
     * 这样可以保证每次放进去的数不小于拿出来的数，并且一个不漏的操作所有数
     * 然后考虑本题，因为数组内可以有负数，所以可以算出所有负数的和，然后将这些数取绝对值
     *
     * @param nums 整数数组
     * @param k    正整数
     * @return 数组的第k大和
     */
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0, neSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] < 0) {
                neSum += nums[i];
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);

        long ans = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        q.add(new long[]{nums[0], 0});
        for (int i = 2; i <= k; i++) {
            long[] poll = q.poll();
            assert poll != null;
            ans = poll[0];
            if (poll[1] + 1 == n) {
                continue;
            }
            q.add(new long[]{poll[0] + nums[(int) (poll[1] + 1)], poll[1] + 1});
            q.add(new long[]{poll[0] - nums[(int) poll[1]] + nums[(int) (poll[1] + 1)], poll[1] + 1});
        }
        return sum - neSum - ans;
    }
}