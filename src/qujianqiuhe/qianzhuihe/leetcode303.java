package qujianqiuhe.qianzhuihe;

class NumArray303 {

    int[] arr;

    public NumArray303(int[] nums) {
        int n = nums.length;
        arr = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1] + arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return arr[right + 1] - arr[left];
    }
}

/*
  Your NumArray object will be instantiated and called as such:
  NumArray obj = new NumArray(nums);
  int param_1 = obj.sumRange(left,right);
 */