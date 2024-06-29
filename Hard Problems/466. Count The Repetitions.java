class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
         int l1 = s1.length(), l2 = s2.length();
        int[] next = new int[l2 + 1];
        int[] count = new int[l2 + 1];
        int cnt = 0, p = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < l1; j++) {
                if (s1.charAt(j) == s2.charAt(p)) {
                    p++;
                }
                if (p == l2) {
                    cnt++;
                    p = 0;
                }
            }
            count[i] = cnt;
            next[i] = p;
            for (int j = 0; j < i; j++) {
                if (next[j] == p) {
                    int prev_count = count[j];
                    int pattern_count = (count[i] - count[j]) * ((n1 - j - 1) / (i - j));
                    int remain_count = count[j + (n1 - j - 1) % (i - j)] - count[j];
                    return (prev_count + pattern_count + remain_count) / n2;
                }
            }
        }
        return count[n1 - 1] / n2;
    }
}