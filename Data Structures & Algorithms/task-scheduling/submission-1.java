class Solution {
    /*
        general idea 
        1. sort task according to the character number
        2. choose the most frequency element as soon as possiable
        3. 
    */
    public int leastInterval(char[] tasks, int n) {
        // validate input

        if(n == 0)
        {
            return tasks.length;
        }

        int[] chs = new int[26];
        int maxFre = 0;
        int countMaxFre = 0;
        
        for(char task : tasks)
        {
            chs[task - 'A'] ++;
            maxFre = Math.max(maxFre,chs[task - 'A']);
        }

        HashSet<Character> set = new HashSet<>();

        //System.out.println("check here " + chs[0]);
        for(char task : tasks)
        {
            if(chs[task - 'A'] == maxFre)
            {
                set.add(task);
            }
        }
        countMaxFre = set.size();

        return Math.max(tasks.length,(maxFre - 1) * (n + 1) + countMaxFre);

      
    }
}
