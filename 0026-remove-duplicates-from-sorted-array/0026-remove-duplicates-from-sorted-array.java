
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int k = 0;

        for (int num : set) {
            nums[k] = num;
            k++;
        }

        Arrays.sort(nums, 0, k);

        return k;
    }
}
