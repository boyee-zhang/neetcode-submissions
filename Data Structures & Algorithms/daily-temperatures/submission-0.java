class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i ++)
        {
            if(stack.isEmpty())
            {
                stack.push(new int[] {temperatures[i],i});
            }
            else
            {
                while(!stack.isEmpty() && temperatures[i] > stack.peek()[0])
                {
                    int[] cur = stack.pop();
                    res[cur[1]] = i - cur[1];
                }
                stack.push(new int[] {temperatures[i],i});
            }
        }

        return res;
    }
}
