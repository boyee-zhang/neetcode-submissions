class Solution {

    // the task schedualer 

    /*
        A x x x A x x x A
        X Y x X
    */
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> count = new HashMap<>();

        List<Character> max = new LinkedList<>();
        int maxCount = 0;

        for(char c : tasks)
        {
            count.put(c,count.getOrDefault(c,0) + 1);
        }

        for(char c : count.keySet())
        {
            if(count.get(c) > maxCount)
            {
                maxCount = count.get(c);
                max.clear();
                max.add(c);
            }
            else if(count.get(c) == maxCount)
            {
                max.add(c);
            }
        }

        // System.out.println(count.get(max.get(0)) * n);
        int res = (count.get(max.get(0)) - 1)* (n + 1) + max.size();

        return Math.max(res,tasks.length);
    }
}
