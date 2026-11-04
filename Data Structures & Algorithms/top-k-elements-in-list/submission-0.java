class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> nToFreq = new HashMap<>();
        for (int n : nums) {
            nToFreq.compute(n, (_k, v) -> (v == null) ? 1 : v + 1);
        }

        Map<Integer, List<Integer>> freqToN = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : nToFreq.entrySet()) {
            freqToN.computeIfAbsent(e.getValue(), f -> new ArrayList<>());
            freqToN.get(e.getValue()).add(e.getKey());
        }

        List<Integer> freqs = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : freqToN.entrySet()) {
            freqs.add(e.getKey());
        }

        freqs.sort(Collections.reverseOrder()); // descending

        int[] res = new int[k];
        int currFreqIdx = 0;
        for (int i = 0; i < k; i++) {
            int currFreq = freqs.get(currFreqIdx);
            List<Integer> ns = freqToN.get(currFreq);
            int popped = ns.remove(0);
            res[i] = popped;
            if (ns.isEmpty()) {
                currFreqIdx++;
            }
        }

        return res;
    }
}
