class Solution {
    public int countComponents(int n, int[][] edges) {
        
        if(n == 1)
        {
            return 1;
        }
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges)
        {
            int first = edge[0];
            int second = edge[1];

            adj.putIfAbsent(first, new LinkedList<>());
            adj.putIfAbsent(second, new LinkedList<>());

            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        boolean[] visited = new boolean [n];
        int count = 0;

        for(int i = 0; i < n; i ++)
        {   
            if(!visited[i])
            {
                dfs(adj,i, visited);
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

        if(adj.get(node) != null)
        {
            for(int next : adj.get(node))
            {
                dfs(adj,next,visited);
            }
        }

    }
}
