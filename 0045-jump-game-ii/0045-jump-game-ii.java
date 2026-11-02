class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int minreach=0;
        int currentend=0;
        for(int i=0;i<nums.length-1;i++){
            minreach=Math.max(minreach,i+nums[i]);

            if(i==currentend){
                jumps++;
                currentend=minreach;
            }
        }
        return jumps;
    }
}