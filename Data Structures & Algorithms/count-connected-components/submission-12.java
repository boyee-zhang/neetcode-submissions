class Solution {
    /*
        1. first of all, we need to build a adj list to indicate different relationship
        2. accoding to new relation to travel, count how many isolated island
        3.  
    */
    public int countComponents(int n, int[][] edges) {
        if(n == 1)
        {
            return 1;
        }
        if(edges.length == 0)
        {
            return n;
        }
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        // build adj list
        for(int[] edge : edges)
        {
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0 ; i < n; i ++)
        {
            if(!visited[i])
            {
                dfs(adj,i,visited);
                count ++;
            }
            
        }

        return count;
    }

    public void dfs(HashMap<Integer,List<Integer>> adj, int node, boolean[] visited)
    {
        if(visited[node])
        {
            return;
        }
        visited[node] = true;
        if(adj.get(node) == null)
        {
            return;
        }
        
        for(int next : adj.get(node))
        {
            dfs(adj,next,visited);
        }
    }

   
}