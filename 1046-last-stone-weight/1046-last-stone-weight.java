class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stone : stones) {
            pq.add(-stone);
        }

        while (pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            if (x != y) {
                pq.add(x - y);
            } 
        }

        return pq.isEmpty() ? 0 : -pq.remove();
    }
}