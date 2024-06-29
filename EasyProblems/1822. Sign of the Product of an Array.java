class Solution {
    public int arraySign(int[] nums) {
        int productSign = 1;
        for(int num: nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                productSign *= -1;
            }
        }
        if(productSign > 0)
        return 1;
        else
        return -1;
    }
}