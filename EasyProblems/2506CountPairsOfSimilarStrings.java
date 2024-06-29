class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; ++i){
            String word1 = words[i];
            int[] f1 = new int[26]; //frequency array 1
            
            for(int a = 0; a < word1.length(); ++a){ //making frequency array for word1
                char ch = word1.charAt(a);
                f1[ch - 'a']++;
            }
            
            for(int j = i + 1; j < words.length; ++j){
                String word2 = words[j];
                int[] f2 = new int[26]; //frequency array 2
    
                for(int b = 0; b < word2.length(); ++b){ //making frequency array for word2
                    char ch = word2.charAt(b);
                    f2[ch - 'a']++;
                }
                
                boolean flag = true;
                for(int k = 0; k < 26; ++k){
                    if((f1[k] > 0 && f2[k] == 0) || (f1[k] == 0 && f2[k] > 0)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag) count++;
            }
        }
        
        return count;
    }
}
