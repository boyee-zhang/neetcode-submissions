class Solution {

    /*  
        1. First of all , it must be a graph problem. 
        2. DFS should be find 
        3. choose any of the start,try to find a correct path
        4. if can find some path could match the course Number requirement. return true else return false

    */
    
    /*
        1. build a indegree list 
        2. first round if some node indegree is 0, put this node into queue
        3. take one node from queue and minus this node relative indegree
        

    */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < numCourses; i ++)
        {
            map.put(i, new ArrayList<>());
        }

        for(int[] courses : prerequisites)
        {
            indegree[courses[0]] ++;
            map.get(courses[1]).add(courses[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < numCourses; i ++)
        {
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
            
            for(int nei : map.get(node))
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
