class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*

            require:
                - return a array have same length of temperatures,and it contain the first warmer day after current day
            invariant:
                - brute force is O(N^2) 
                - the first right element larger than the current element
                - which means the waiting list must be a decline array, ex: [5 4 3 3 2 1]
                -  
        */


        int len = temperatures.length;
        int[] res = new int [len];

        ArrayDeque<int[]> st = new ArrayDeque<>();

        for(int i = 0; i < len; i++)
        {
            int t = temperatures[i];

            while(!st.isEmpty() && st.peek()[0] < t)
            {
                int index = st.peek()[1];

                res[index] = i - index;
                st.pop();
            }

            st.push(new int[] {t,i});
        }


        return res;
    }
}
