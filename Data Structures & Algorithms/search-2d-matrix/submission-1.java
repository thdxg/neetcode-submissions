class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // compare row[0]s and find the row
        // and then do binary search in the row
        int rows = matrix.length;
        int cols = matrix[0].length;
        int u = 0, d = rows - 1;
        while (u < d) {
            int m = (u + d) / 2;
            int v1 = matrix[m][0];
            int v2 = matrix[m][cols - 1];
            if (v1 == target || v2 == target) {
                return true;
            } else if (v1 > target) {
                d = m - 1;
            } else if (v2 < target) {
                u = m + 1;
            } else {
                u = m;
                d = m;
                break;
            }
        }

        int[] row = matrix[u];
        int l = 0, r = row.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (row[m] == target) {
                return true;
            } else if (row[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
