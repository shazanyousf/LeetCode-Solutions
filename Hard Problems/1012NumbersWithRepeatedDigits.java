class Solution {
    public int numDupDigitsAtMostN(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        
        // all number with no repeat and length < len
        int unique = 0;
        for (int i = 1; i < len; i++) {
            unique += totalNoRepeat(i);
        }
        
		// all number with no repeat and length == len
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (i = 0; i < len; i++) {
            int d = str.charAt(i) - '0';
            
            int temp = pivotChoice(set, d, i == 0);
            for (int j = i+1; j < len; j++) {
                temp *= (10 - j);
            }
            
            unique += temp;
            if (!set.add(d)) break;       // no need to continue after seeing repeated digits
        }
        
        if (i == len) unique++;      // the number n itself
        
        return n - unique;
    }
    
    private int totalNoRepeat(int d) {
        int res = 9;
        for (int i = 1; i < d; i++) {
            res *= (10 - i);
        }
        return res;
    }
    
    private int pivotChoice(Set<Integer> set, int d, boolean first) {
        int res = 0;
        int i = (first ? 1 : 0);
        
        while (i < d) {
            if (!set.contains(i++)) res++;
        }
        
        return res;
    } 
    
}