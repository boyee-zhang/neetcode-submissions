class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++)
        {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int [numCourses];

        for(int[] p : prerequisites)
        {
            int to = p[0];
            int from = p[1];

            graph.get(from).add(to);
            indegree[to] ++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0; i < size; i ++)
            {
                int cur = q.poll();
                res.add(cur);

                for(int next : graph.get(cur))
                {
                    indegree[next] --;

                    if(indegree[next] == 0)
                    {
                        q.add(next);
                    }
                }
            }
        }
        int[] ans = new int [res.size()];

        for(int i = 0; i < ans.length; i ++)
        {
            ans[i] = res.get(i);
        }

        if(res.size() == numCourses)
        {
            return ans;
        }
        else
        return new int[]{};
    }
}
