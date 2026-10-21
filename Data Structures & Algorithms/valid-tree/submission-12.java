class Solution {

    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
            this.count = n;
        }

        // 路径压缩版本的 find
        public int find(int i) {
            if (parent[i] == i) return i;
            // 递归寻找根节点，并顺手把自己的 parent 指向根节点
            return parent[i] = find(parent[i]); 
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            
            if (rootI != rootJ) {
                parent[rootI] = rootJ; // 把一棵树的根挂在另一棵树的根下
                count--; // 合并成功，连通分量减一
                return true; 
            }
            return false; // 已经连通了，返回 false（在判环题里这代表有环！）
        }
    }

    public boolean validTree(int n, int[][] edges) {

        // basically we need to check if this graph have cycle
        
        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges)
        {
            if(!uf.union(edge[0],edge[1]))
            {
                return false;
            }
        }

        if(uf.count != 1) return false;
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
