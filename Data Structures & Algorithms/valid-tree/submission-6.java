class Solution {
    // first this is a undirected graph 
    // detect if this graph have cycle 
    // if have some node is not connectd

    public boolean validTree(int n, int[][] edges) {
        //validate input
        if(n == 0 || edges.length == 0)
        {
            return true;
        }

        //build the adj list

        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int[] edge : edges)
        {
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

   
            if(!dfs(adj,0,-1,visited))
            {
                return false;
            }
        

        return visited.size() == n;
        
    }
    
    public boolean dfs(HashMap<Integer,List<Integer>> adj , int node, int parent,HashSet<Integer> visited)
    {
        if(visited.contains(node))
        {
            return false;
        }

        visited.add(node);

        for(int next : adj.get(node))
        {
            if(next == parent)
            {
                continue;
            }
            if(!dfs(adj,next,node,visited))
            {
                return false;
            }
        }

        return true;
    }

}
