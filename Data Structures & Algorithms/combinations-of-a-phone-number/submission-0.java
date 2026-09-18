class Solution {
    // dfs
    // 3'd' -> 4 'g'
    //      -> 4 'h'
    // char[][]
    // dfs(String digits, int pos)

    char[][] dToC = new char[][]{
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {'a', 'b', 'c', 0},
        {'d', 'e', 'f', 0},
        {'g', 'h', 'i', 0},
        {'j', 'k', 'l', 0},
        {'m', 'n', 'o', 0},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v', 0},
        {'w', 'x', 'y', 'z'},
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        dfs(digits, "");
        return res;
    }

    private void dfs(String digits, String curr) {
        if (digits.length() == 0) {
            res.add(curr);
            return;
        }
        int digit = digits.charAt(0) - '0';
        for (int i = 0; i < 4; i++) {
            char c = dToC[digit][i];
            if (c == 0) continue;
            dfs(digits.substring(1), curr + c);
        }
    }
}
