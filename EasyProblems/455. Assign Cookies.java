class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndx = 0, gSz = g.length, sSz = s.length;
        for(int indx = 0; indx < sSz; indx++){
            if(gIndx < gSz && g[gIndx] <= s[indx]){
                gIndx++;
            }
        }
        return gIndx; 
    }
}