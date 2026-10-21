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

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i ++)
        {
            map.put(i, new ArrayList<>());
        }

        for(int[] connection : edges)
        {
            map.get(connection[0]).add(connection[1]);
            map.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];

        // 之后应该是用一种 dfs 或者 bfs 都是可以的 进行遍历
        int count = 0;
        for(int i = 0; i < n; i ++)
        {
            if(!visited[i])
            {
                dfs(i,visited,map);
                count ++;
            }
        }

        return count;
    }

    private void dfs(int cur ,boolean[] visited, Map<Integer,List<Integer>> map)
    {
        visited[cur] = true;

        for(int next : map.get(cur))
        {
            if(!visited[next])
            {
                dfs(next,visited, map);
            }
        }

    }
}