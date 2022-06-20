class NumArray307 {

    int[] array;
    int[] sums;

    public NumArray307(int[] nums) {
        array = nums;
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public void update(int index, int val) {
        int temp = val - array[index];
        array[index] = val;
        for (int i = index; i < array.length; i++) {
            sums[i] += temp;
        }
    }

    public int sumRange(int left, int right) {
        return left != 0 ? sums[right] - sums[left] : sums[right];
    }
}