package offer.offer11;

import java.util.Arrays;

class Solution {
    public int minArray(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}