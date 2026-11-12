class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int icount=1;
        int dcount=1;
        int max=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                icount++;
                dcount=1;
            }
            else 
                if(nums[i]>nums[i+1]){
                    dcount++;
                    icount=1;
                
            }
            else{
                icount=1;
                dcount=1;
            }
            max=Math.max(max,Math.max(icount,dcount));
        }
        return max;
    }
}
