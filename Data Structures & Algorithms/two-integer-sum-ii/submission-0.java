class Solution {
    // iterate every element
    // for each, find the complement using binary search
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            int comp = target - numbers[i];
            while (l <= r) {
                int m = i + 1 + r - l;
                int curr = numbers[m];
                if (curr == comp) {
                    return new int[]{i + 1, m + 1};
                }
                if (curr < comp) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return null;
    }
}
