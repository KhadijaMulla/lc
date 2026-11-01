
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=0;
        int max=0;
        int ans=0;
        for(int key:map.keySet()){
            count=map.get(key);

            if(count>max){
                max=count;
                ans=key;
            }
        }
        return ans;
    }
}
