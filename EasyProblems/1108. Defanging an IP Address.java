class Solution {
    private static final char DELIMITER = '.';
    public String defangIPaddr(String address) {
        if(address == null || address.isEmpty()){
            return "";
        }
        var sb = new StringBuilder();
        for(char ch : address.toCharArray()){
            if(ch == DELIMITER){
                sb.append("[.]");
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}