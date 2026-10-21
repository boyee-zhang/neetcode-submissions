class Solution {
    HashMap<Integer,List<Integer>> adj = new HashMap<>();
    /*
        general idea 1
        1. delete most degree node 

        //delet most degree node
        // int mostdegree = 0;
        // int max = 0;

        // for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet())
        // {
        //     if(entry.getValue().size() > max)
        //     {
        //         mostdegree = entry.getKey();
        //         max = entry.getValue().size();
        //     }
        // }

        // for(int next : adj.get(mostdegree))
        // {
        //     if(adj.get(next).size() > 1)
        //     {
        //         return new int[]{mostdegree,next};
        //     }
        // }

        // return new int[] {};

    */
    public int[] findRedundantConnection(int[][] edges) {
        //buildG(edges);
        int n = edges.length;
     

        for(int[] edge : edges)
        {
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

            boolean[] visited = new boolean[n + 1];

            if(dfs(edge[0], -1,visited))
            {
                return new int[] {edge[0],edge[1]};
            }
        }

        return new int[]{-1,-1};
    }

    public boolean dfs(int node, int parent, boolean[] visited)
    {   
        if(visited[node])
        {
            return true;
        }
        visited[node] = true;

        for(int next: adj.get(node))
        {
            if(next == parent) continue;
            if(dfs(next,node,visited))
            {
                return true;
            }
        }

        return false;
    }

    
}
