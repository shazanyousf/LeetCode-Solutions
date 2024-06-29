class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ops = 0;
        int prev = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
          int k=nums[i]/prev;

            if ((nums[i]) % prev!=0) {
               k++;
               prev=nums[i]/k;
            }
            ops +=k-1;
        }
        
        return ops;
    }
}