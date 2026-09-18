class Solution {
    // abcde bbzaf abbzbcdeaf
    // every character of s3
    //     state: position of s1, position of s2
    //     choice: use s1, use s2
    //     return use s1 || use s2
    //     base: out of s3 chars then true
    //     s1 s2 both invalide then false

    String s1, s2, s3;
    int[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.dp = new int[s3.length()+1][s1.length()+1][s2.length()+1];
        return rec(s3, 0, 0);
    }

    private boolean rec(String rem, int pos1, int pos2) {
        if (rem.length() == 0) return pos1 == s1.length() && pos2 == s2.length();
        char target = rem.charAt(0);
        char c1 = pos1 < s1.length() ? s1.charAt(pos1) : 0;
        char c2 = pos2 < s2.length() ? s2.charAt(pos2) : 0;
        int memo = dp[rem.length()][pos1][pos2];
        if (memo != 0) return memo == 1;

        boolean res = false;
        if (target == c1) {
            res |= rec(rem.substring(1), pos1 + 1, pos2);
        }
        if (target == c2) {
            res |= rec(rem.substring(1), pos1, pos2 + 1);
        }
        dp[rem.length()][pos1][pos2] = res ? 1 : 2;
        return res;
    }
}
