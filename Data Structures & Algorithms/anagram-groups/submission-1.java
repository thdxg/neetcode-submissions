class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character, Integer>> groups = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        // groups and res must equal in length
    loop:
        for (String s : strs) {
            // construct s' hashmap
            Map<Character, Integer> m = new HashMap<>();
            for (char c : s.toCharArray()) {
                m.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
            }

            for (int i = 0; i < groups.size(); i++) {
                // if anything matches, append to res[i]
                // res[i] is guaranteed to be non-empty since res.size() == groups.size()
                Map<Character, Integer> g = groups.get(i);
                if (g.equals(m)) {
                    res.get(i).add(s);
                    continue loop;
                }
            }
            groups.add(m);
            res.add(new ArrayList<>(List.of(s)));
        }

        return res;
    }
}
