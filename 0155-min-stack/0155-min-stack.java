class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        
        // Push to min stack only when the new val is the new minimum
        if (minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{ val, 1 });
        // If the new val equals to the current minimum, update its frequency
        } else if (val == minStack.peek()[0]) {
            minStack.peek()[1] += 1;
        }
    }
    
    public void pop() {
        // Update minimum frequency if the top element happens to be the minimum
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1] -= 1;
        }

        // Remove the minimum value if its frequency is now 0
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }

        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */