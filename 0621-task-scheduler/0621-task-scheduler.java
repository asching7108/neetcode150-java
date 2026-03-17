class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        for (char task : tasks) {
            count[task - 'A'] += 1;
        }

        int total = tasks.length;
        int ans = 0;

        while (total > 0) {
            Arrays.sort(count, Collections.reverseOrder());
            for (int i = 0; i <= n; i++) {
                if (i < 26 && count[i] > 0) {
                    count[i] -= 1;
                    total -= 1;
                }
                ans += 1;
                if (total == 0) {
                    break;
                }
            }
        }

        return ans;
    }
}