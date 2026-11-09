class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);              // 1 step
            fast = findSquare(findSquare(fast));  // 2 steps
        } while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int r = num % 10;
            ans += r * r;
            num /= 10;
        }
        return ans;
    }
}