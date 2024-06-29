class Solution {
    public int thirdMax(int[] nums) {
       long max = Long.MIN_VALUE;
       long secondMax = Long.MIN_VALUE;
       long thirdMax = Long.MIN_VALUE;

       for (int i = 0; i < nums.length; i++) {

           if (nums[i] > thirdMax 
               && nums[i] != max 
               && nums[i]!= secondMax) {

               if (nums[i] >= secondMax) {

                   if (nums[i] >= max) {
                       
                       thirdMax = secondMax;
                       secondMax = max;
                       max = nums[i];
                       continue;
                   }

                   thirdMax = secondMax;
                   secondMax = nums[i];
                   continue;
               }

               if (nums[i] > thirdMax) thirdMax = nums[i];
           }
       }

       return thirdMax == Long.MIN_VALUE ? (int) max : (int) thirdMax;
   }
}