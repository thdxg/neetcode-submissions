class Solution {
    // two pointer
    // l: start, r: end
    // if chars at l and r are not equal, return false
    // at the end, return true
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] lows = s.toLowerCase().toCharArray();
        while (l < r) {
            while (l < r && !isAlphaNumeric(lows[l])) l++;
            while (l < r && !isAlphaNumeric(lows[r])) r--;
            if (lows[l] != lows[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return 'a' <= c && c <= 'z' || '0' <= c && c <= '9';
    }
}
