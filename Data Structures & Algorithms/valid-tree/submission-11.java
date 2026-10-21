class Solution {
    public boolean validTree(int n, int[][] edges) {

        // basically we need to check if this graph have cycle
        
        //first build adjasent graph 
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges)
        {   
            int first = edge[0];
            int second = edge[1];

            adj.putIfAbsent(first,new LinkedList<>());
            adj.putIfAbsent(second,new LinkedList<>());

            adj.get(first).add(second);
            adj.get(second).add(first);
        }


        HashSet<Integer>visited = new HashSet<>();

        if(dfs(adj,0,-1,visited))
        {
            return false;
        }

        if(visited.size() != n)
        {
            return false;
        }

        return true;
    }

    public boolean dfs(HashMap<Integer,List<Integer>> adj,int node, int parent,HashSet<Integer> visited)
    {
        if(visited.contains(node))
        {
            return true;
        }

        visited.add(node);

        if(adj.get(node) != null)
        {
            for(int next : adj.get(node))
            {   
                if(next == parent)
                {
                    continue;
                }

                if(dfs(adj,next,node,visited))
                {
                    return true;
                }
            }
        }
        

        return false;
    }
}
