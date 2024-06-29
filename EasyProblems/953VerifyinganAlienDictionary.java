class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<words.length-1; i++){
            String string1 = words[i];
            String string2 = words[i+1];
            int len = Math.max(string1.length(), string2.length()); // length to traverse

            for(int j=0; j<len; j++){
                int index1 = -1; // as index starts from 0,
                int index2 = -1; // we are initialising index with -1

                if(j<string1.length()){
                    index1 = order.indexOf(string1.charAt(j));
                }
                if(j<string2.length()){
                    index2 = order.indexOf(string2.charAt(j));
                }
                if(index1<index2){ // lexicographycally ordered
                    break;
                }
                else if(index1>index2){ // not lexicographically ordered
                    return false;
                }
            }
        }
        return true;
    }
}