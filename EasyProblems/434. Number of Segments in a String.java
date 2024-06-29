class Solution {
    public int countSegments(String s) {
        if(s.length()==0)
          return 0;
        int i=0,x=1;
        if(s.charAt(0)==' '){
            i=1;x=0;
            while(i<s.length()-1){
                if(s.charAt(i)!=' '&&s.charAt(i+1)==' '){
                    x++;
                }
                i++;
            }
            if(s.charAt(s.length()-1)!=' ')
              x+=1;
            return x;
        }
        while(i<s.length()-1){
            if(s.charAt(i)==' '&&s.charAt(i+1)!=' '){
                x++;
            }
            i++;
        }
        return x;
    }
}