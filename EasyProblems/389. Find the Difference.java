class Solution {
    public char findTheDifference(String s, String t) {
        int i,xor=0;
        for(i=0;i<s.length();i++){
            xor = xor^s.charAt(i);
        }
        for(i=0;i<t.length();i++){
            xor=xor^t.charAt(i);
        }
        return (char)(xor);
    }
}