class Solution {
    // maintain a hashmap of visited number -> index
    // if current number has a complement in hashmap, record indices
    // every iteration records to hashmap
    // time: O(n), space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complement = seen.get(target - nums[i]);
            if (complement != null) {
                return new int[]{complement, i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
