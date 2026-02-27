class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            ans = Math.max(ans, price - min);
        }
        return ans;
    }
}