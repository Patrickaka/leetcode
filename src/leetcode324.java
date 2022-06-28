import java.util.Arrays;

class Solution324 {
    public static void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for (int i = (tmp.length - 1 >> 1), j = tmp.length - 1, cnt = 0; i <= j; ) {
            if (cnt >= nums.length) {
                break;
            }
            nums[cnt++] = tmp[i--];
            if (cnt >= nums.length) {
                break;
            }
            nums[cnt++] = tmp[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}