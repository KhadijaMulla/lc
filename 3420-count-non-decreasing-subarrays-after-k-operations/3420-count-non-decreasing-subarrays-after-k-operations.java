
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] deque = new int[n];
        int front = 0;
        int rear = -1;

        int j = n - 1;
        long cost = 0;
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {

            while (front <= rear && nums[deque[rear]] <= nums[i]) {
                int idx = deque[rear--];

                int next = (front > rear) ? j + 1 : deque[rear];

                cost -= (long)(next - idx) * (nums[idx] - nums[i]);
            }

            deque[++rear] = i;

            while (cost > k) {
                int idx = deque[front];

                cost -= nums[idx] - nums[j];

                if (idx == j) {
                    front++;
                }

                j--;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
