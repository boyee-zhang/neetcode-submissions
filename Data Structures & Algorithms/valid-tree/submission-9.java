class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < n; i ++)
        {
            adj.put(i,new LinkedList<>());
        }

        for(int[] edge : edges)
        {
            int first = edge[0];
            int second = edge[1];
            
            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        boolean[] visited = new boolean [n];

        int count = 0;
        for(int i = 0; i < n; i ++)
        {   
            if(visited[i])
            {
                continue;
            }
            else
            {
                count ++ ;
            }
            if(!dfs(adj, i , - 1, visited))
            {
                return false;
            }
            
        }

        return count != 1 ? false : true;
    }

    public boolean dfs(HashMap<Integer,List<Integer>> adj, int node, int parent,boolean[] visited)
    {
        
        visited[node] = true;

        for(int next : adj.get(node))
        {   
            if(next == parent)
            {
                continue;
            }

            if(visited[next])
            {
                return false;
            }

            if(!dfs(adj,next,node,visited))
            {
                return false;
            }
        }

        return true;
    }
}
