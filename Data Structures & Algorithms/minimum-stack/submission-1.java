class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(!minStack.isEmpty() && minStack.peek() >= val)
        {
            minStack.push(val);
        }
        if(minStack.isEmpty())
        {
            minStack.push(val);
        }
    }
    
    public void pop() {
        System.out.println("stack peek " + stack.peek());
        System.out.println("min stack peek " + minStack.peek());
        if(stack.peek().equals(minStack.peek()))
        {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
