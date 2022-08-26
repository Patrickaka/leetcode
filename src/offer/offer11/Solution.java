package offer.offer11;

class Solution {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r && numbers[0] == numbers[r]) {
            r--;
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (numbers[mid] >= numbers[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r + 1 < n ? numbers[r + 1] : numbers[0];
    }
}