class Solution {
    public boolean isPalindrome(String s) {
        //Convert the string into lower case
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //Convert this string into StringBuilder so that u can reverse it
        StringBuilder sb = new StringBuilder(str);
        //Reverse the String Builder
        sb.reverse();
        //Convert the StringBuilder back into String ans
        String ans = sb.toString();
        //Intialize a for loop that will iterate over the string
        for(int i = 0; i<str.length(); i++){
            //Compare the characters of String str with characters of string ans
            if(str.charAt(i)!= ans.charAt(i)){
                //if the characters that doesn't match return false else return true
                return false;
            }
        }
        return true;
    }
}