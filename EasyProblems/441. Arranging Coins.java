class Solution {

    public int arrangeCoins(int n) {
       
        long left = 0;
        long right = n;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            //Total coins that can be in mid number of levels 
            long total_coins = mid * (mid + 1) / 2;
            
            if (total_coins == n) {
                return (int)mid;
            } else if (total_coins < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
       //Since we are asked to return the maximum number of levels
        return (int)right;
    }
}