class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int price : prices) {
            if (price < min) {
                min = Math.min(min, price);
            } else if (price - min > ans) {
                ans = price - min;
            }
        }
        return ans;
    }
}