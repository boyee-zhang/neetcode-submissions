class Solution {

    /*
        require:   
            - this course map should not contain a circle 
            - dfs should (bian li) whole map means visited size == numCourses
            - 0 <= numCourse <= 1000
            - all pre is pairs are unique
        
        invariant:
            - only visited unvisited course 
            - if next step is a visited course, return false
            - if the final visited set size != numCourse ,return false
            - otherwise return true
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++)
        {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int [numCourses];

        for(int[] p : prerequisites)
        {
            int from = p[0];
            int to = p[1];

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

        if(res.size() == numCourses)
        {
            return true;
        }
        else
        return false;
    }
    /*
            invariant:
            - only visited unvisited course 
            - if next step is a visited course, return false
            - if the final visited set size != numCourse ,return false
            - otherwise return true
    */

    public boolean dfs(int curr,Map<Integer,List<Integer>> graph,Set<Integer> visited,Set<Integer> curPath)
    {
        if(curPath.contains(curr))
        {
            System.out.println("1");
            return true;
        }

        if(visited.contains(curr))
        {
            // System.out.println("2");

            return false;
        }

    if(graph.get(curr) != null)
    {
        for(int next : graph.get(curr))
        {

            curPath.add(curr);
            if(dfs(next,graph,visited,curPath))
            {
                return true;
            }
            curPath.remove(curr);
        }
    }
        visited.add(curr);
        return false;
    }
}
