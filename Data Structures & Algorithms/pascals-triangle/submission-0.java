class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // first row
        triangle.add(List.of(1));
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> curr = triangle.get(i);
            List<Integer> next = new ArrayList<>();
            triangle.add(next);
            next.add(1);
            for (int j = 0; j < curr.size() - 1; j++) {
                next.add(curr.get(j) + curr.get(j+1));
            }
            next.add(1);
        }
        return triangle;
    }
}