class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0 || edges.length == 0)
        {
            return true;
        }

        Map<Integer,List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] edge : edges)
        {
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());
            adj.get(edge[1]).add(edge[0]);  
            adj.get(edge[0]).add(edge[1]);
        }

        if(!dfs(adj,visited, 0, -1))
        {
            return false;
        }
        return visited.size() == n;
    }

    public boolean dfs(Map<Integer,List<Integer>> map, Set<Integer> visited, int node, int parent)
    {
        if(visited.contains(node))
        {
            return false;
        }

        visited.add(node);

        for(int next : map.get(node))
        {
            if(next == parent)
            {
                continue;
            }

            if(!dfs(map,visited,next,node))
            {
                return false;
            }
        }

        return true;
    }
}
