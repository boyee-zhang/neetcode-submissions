class Solution {

    /*  
        1. First of all , it must be a graph problem. 
        2. DFS should be find 
        3. choose any of the start,try to find a correct path
        4. if can find some path could match the course Number requirement. return true else return false

    */


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i ++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites)
        {
            indegree[pre[0]] ++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < numCourses; i ++){
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            count ++;
            for(int nei : adj.get(node))
            {
                indegree[nei] --;
                if(indegree[nei] == 0)
                {
                    queue.add(nei);
                }
            }
        }

        return count == numCourses;
    }

  
}
