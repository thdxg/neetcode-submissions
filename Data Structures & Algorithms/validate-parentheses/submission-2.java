class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                case ']':
                case '}':
                    if (st.isEmpty() || st.peek() != pair(c)) return false;
                    st.pop();
                    break;
                default:
                    st.push(c);
            }
        }
        return st.isEmpty();
    }

    private char pair(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                throw new Error("unrecognized character");
        }
    }
}
