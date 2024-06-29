class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String,Boolean> ispresent = new HashMap<>();

        for(String it : words){
            ispresent.put(it, true);
        }

        List<String> res = new ArrayList<>();

        for(String it : words){
            int n = it.length();

            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);

            dp[0] = 1;

            for(int i = 0;i < n;i++){
                if(dp[i] == -1){
                    continue;
                }

                for(int j = i+1;j <= n;j++){
                    if(j - i < n && ispresent.containsKey(it.substring(i, j))){
                        dp[j] = 1;
                    }
                }

                if(dp[n] == 1){
                    res.add(it);
                    break;
                }
            }
        }

        return res;

    }
}