package offer.offerII30;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    static int[] nums = new int[200010];
    Map<Integer, Integer> map = new HashMap<>();
    int idx = 0;
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, idx);
        nums[idx++] = val;
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        if (loc != idx - 1) {
            map.put(nums[idx - 1], loc);
        }
        nums[loc] = nums[idx - 1];
        idx--;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int ran = random.nextInt(idx);
        return nums[ran];
    }
}