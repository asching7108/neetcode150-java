class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1];
            }
        };

        Queue<int[]> pq = new PriorityQueue(cmp);
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][0]);
    }
}