class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int len = str.length();
        int mid = len/2;
        int i = 0;
        while(i< mid){
            if(str.charAt(i) != str.charAt(len-i-1))
                return false;
                i++;
        }
        return true;
    }
}