class Solution {
    int[][] memo;

    public List<Integer> getRow(int rowIndex) {
        memo = new int[rowIndex+1][rowIndex+1];
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(getCell(rowIndex, i));
        }
        return row;
    }

    private int getCell(int row, int col) {
        if (row == 0 || col == 0 || row == col) return 1;
        if (memo[row][col] != 0) return memo[row][col];
        memo[row][col] = getCell(row-1, col-1) + getCell(row-1, col);
        return memo[row][col];
    }
}