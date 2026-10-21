class Solution {
    Boolean[] memo;
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        boolean positionA = false;
        boolean positionB = false;
        boolean positionC = false;

        for(int[] t : triplets)
        {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
            {
                continue;
            }

            if(t[0] == target[0])
            {
                positionA = true;
            }

            if(t[1] == target[1])
            {
                positionB = true;
            }

            if(t[2] == target[2])
            {
                positionC = true;
            }
        }

        return positionA && positionB && positionC;
    }

    public boolean dfs(int[][] t,int start ,int[] target, int[] cur)
    {

        if(target[0] == cur[0] && target[1] == cur[1] && target[2] == cur[2])
        {
            return true;
        }

        if(start >= t.length)
        {   
            return false;
        }

        boolean skip = dfs(t,start + 1, target, cur);
        boolean choose = false;

        int[] next = new int [3];

        next[0] = Math.max(t[start][0],cur[0]);
        next[1] = Math.max(t[start][1],cur[1]);
        next[2] = Math.max(t[start][2],cur[2]);
        choose = dfs(t,start + 1, target, next);

        return skip || choose;

    }
}
