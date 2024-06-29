class Solution {
    public boolean check(int[] nums) {
        int irregular = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < nums[i-1])
            irregular++;
            if(irregular > 1)
            return false;
        }
        return irregular == 0?true:nums[nums.length-1] <= nums[0];
    }
}