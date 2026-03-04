class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile: piles) {
            right = Math.max(right, pile);
        }

         while (left < right) {
            int mid = (left + right) / 2;
            int hourSpent = 0;
            for (int pile: piles) {
                hourSpent += pile / mid + (pile % mid > 0 ? 1 : 0);
            }
            // mid is a workable speed
            if (hourSpent <= h) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}