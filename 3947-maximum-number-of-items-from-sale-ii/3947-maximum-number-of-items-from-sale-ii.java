class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxF = 0;
        int minP = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxF = Math.max(maxF, item[0]);
            minP = Math.min(minP, item[1]);
        }

        int[] freq = new int[maxF + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] total = new int[maxF + 1];

        for (int i = 1; i <= maxF; i++) {
            for (int j = i; j <= maxF; j += i) {
                total[i] += freq[j];
            }
        }

        java.util.TreeMap<Integer, Long> bonus = new java.util.TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = total[factor] - 1;

            if (price < 2L * minP && gain > 0) {
                bonus.put(price, bonus.getOrDefault(price, 0L) + gain);
            }
        }

        long rem = budget;
        long ans = 0;

        for (int price : bonus.keySet()) {
            long take = Math.min(rem / price, bonus.get(price));

            ans += take * 2;
            rem -= take * price;
        }

        ans += rem / minP;

        return (int) ans;
    }
}