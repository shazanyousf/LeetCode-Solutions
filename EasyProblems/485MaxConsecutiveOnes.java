class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maximum = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            else{
                count = 0;
            }
            maximum = Math.max(maximum, count);
        }
        return maximum;
    }
}