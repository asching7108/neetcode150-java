class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right;

         while (left <= right) {
            int mid = (left + right) / 2;
            int hourSpent = 0;
            for (int pile: piles) {
                hourSpent += Math.ceil((double) pile / mid);
            }
            // mid is a workable speed
            if (hourSpent <= h) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}