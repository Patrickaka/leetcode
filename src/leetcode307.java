class NumArray {

    int[] array;
    int[] sums;

    public NumArray(int[] nums) {
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

class Solution307 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{9, -8});
        obj.update(0, 3);
        int param_2 = obj.sumRange(1, 1);
        System.out.println(param_2);
    }
}

