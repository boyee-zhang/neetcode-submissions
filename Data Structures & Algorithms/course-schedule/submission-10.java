class Solution {

    //basically check this direct graph if have a cycle
    // 0 means not visited, 1 means visiting, 2 visited
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] course : prerequisites)
        {   
            int from = course[1];
            int to = course[0];

            adj.putIfAbsent(from,new LinkedList<>());
            adj.get(from).add(to);
        }

        int[] states = new int [numCourses];

        for(int i = 0; i < numCourses; i ++)
        {
            if(dfs(adj,i,states))
            {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(HashMap<Integer,List<Integer>> adj,int node, int[] states)
    {
        if(states[node] == 1)
        {
            return true;
        }

        if(states[node] == 2)
        {
            return false;
        }


        states[node] = 1;

        if(adj.get(node) != null)
        {
            for(int next : adj.get(node))
            {
                if(dfs(adj,next,states))
                {
                    return true;
                }
            }
        }


        states[node] = 2;
        return false;
    }
}
