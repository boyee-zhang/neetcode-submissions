class Solution {
    public int countComponents(int n, int[][] edges) {
        
        HashMap<Integer,List<Integer>> adj  = new HashMap<>();

        for(int i = 0; i < n; i ++)
        {
            adj.put(i, new LinkedList<>());
        }

        for(int[] edge : edges)
        {   
            int first = edge[0];
            int second = edge[1];

            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i ++)
        {
            if(!visited[i])
            {
                dfs(visited,adj,i);
                count ++;
            }
        }

        return count;
    }

    public void dfs(boolean[] visited, HashMap<Integer,List<Integer>> adj, int node)
    {
        if(visited[node])
        {
            return;
        }

        visited[node] = true;

        for(int next : adj.get(node))
        {
            dfs(visited,adj,next);
        }
    }
}
