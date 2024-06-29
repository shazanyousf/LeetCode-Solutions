class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        
        int count = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
        }
        return new int[] {count, nums.length - count * 2};
    }
}
