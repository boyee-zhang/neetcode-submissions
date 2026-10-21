class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer,List<Integer>> adj = new HashMap<>();
        List<Integer> path = new ArrayList<>();

        for(int[] pre : prerequisites)
        {
            adj.putIfAbsent(pre[1],new ArrayList<>());
            adj.get(pre[1]).add(pre[0]);
        }
        Map<Integer,Integer> status = new HashMap<>();

        for(int i = 0 ; i < numCourses; i ++)
        {
            if(!dfs(adj,status,i,path))
            {
                return new int[]{};
            }
        }

        int[] res = new int [path.size()];

        Collections.reverse(path);

        for(int i = 0 ; i < res.length; i ++)
        {
            res[i] = path.get(i);
        }

        return res;
    }

    public boolean dfs(Map<Integer,List<Integer>> adj, Map<Integer,Integer> status, int cur , List<Integer> path)
    {
        if(status.containsKey(cur) && status.get(cur) == 1)
        {
            return false;
        }

        if(status.containsKey(cur) && status.get(cur) == 2)
        {
            return true;
        }

        if(adj.get(cur) == null || adj.get(cur).isEmpty())
        {
            path.add(cur);
            status.put(cur,2);
            return true;
        }

        status.put(cur,1);


        for(int next : adj.get(cur))
        {
            if(!dfs(adj,status,next,path))
            {
                return false;
            }
        }
        path.add(cur);
        status.put(cur,2);
        return true;
    }
}
