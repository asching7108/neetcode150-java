class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] prev = stack.pop();
                result[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{ temperatures[i], i });
        }
        return result;
    }
}
