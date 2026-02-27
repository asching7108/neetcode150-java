class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Build frenquency map
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int i = 0;
        for (int j = freq.length - 1; j > 0; j--) {
            for (int n : freq[j]) {
                res[i] = n;
                i += 1;
                if (i == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
