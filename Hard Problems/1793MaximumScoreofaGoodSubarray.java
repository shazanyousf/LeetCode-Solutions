class Solution {
    public int maximumScore(int[] nums, int k) {
        int i=k;
        int j=k;
        int n=nums.length;
        int result=nums[k];
        int min=nums[k];


        while(i>0||j<n-1){
           int left=(i>0)?nums[i-1]:0;
           int right=(j<n-1)?nums[j+1]:0;
           if(left>right){
               min=Math.min(left,min);
               i--;
           }else{
               min=Math.min(right,min);
               j++;
           }
           result=Math.max(result,min*(j-i+1));


        }
        return result;

    }
}