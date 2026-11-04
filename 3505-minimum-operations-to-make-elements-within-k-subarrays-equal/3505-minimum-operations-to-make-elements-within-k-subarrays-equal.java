
import java.util.*;

class Solution {

    class MyMap {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int getMedian() {
            return map.lastKey();
        }
    }

    MyMap lower = new MyMap();
    MyMap upper = new MyMap();

    void add(int val) {
        if (lower.size == 0 || val <= lower.getMedian()) {
            lower.add(val);
        } else {
            upper.add(val);
        }

        balance();
    }

    void remove(int val) {
        if (lower.map.containsKey(val)) {
            lower.remove(val);
        } else {
            upper.remove(val);
        }

        balance();
    }

    void balance() {
        while (lower.size < upper.size) {
            int val = upper.map.firstKey();
            upper.remove(val);
            lower.add(val);
        }

        while (lower.size > upper.size + 1) {
            int val = lower.getMedian();
            lower.remove(val);
            upper.add(val);
        }
    }

    long getCost() {
        long median = lower.getMedian();

        return median * lower.size - lower.sum
                + upper.sum - median * upper.size;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        lower = new MyMap();
        upper = new MyMap();

        for (int i = 0; i < n; i++) {
            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // Skip the current element
                dp[i][j] = dp[i - 1][j];

                // Choose a window ending at index i - 1
                if (i >= x && dp[i - x][j - 1] != INF) {
                    long take = dp[i - x][j - 1]
                            + cost[i - x];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}
