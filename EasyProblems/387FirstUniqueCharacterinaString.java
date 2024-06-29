class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for(var c : s.toCharArray())freq[c - 'a']++;
        for(int indx = 0; indx < s.length(); indx++){
            if(freq[s.charAt(indx) - 'a'] == 1)return indx;
        }
        return -1;
    }
}