
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for (String word : wordDict) {
            set.add(word);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);

                if (dp[j] && set.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
