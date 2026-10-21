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
    Map<Integer,List<Integer>> adj = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       

       //validt input 
        if(prerequisites.length == 0)
        {
            return true;
        }
       //build adj list

        for(int[] pre : prerequisites)
        {
            adj.putIfAbsent(pre[1],new ArrayList<>());
            adj.get(pre[1]).add(pre[0]);         
        }

        HashMap<Integer,Integer> visited = new HashMap<>();

        for(int i = 0 ; i < numCourses; i ++)
        {
            if(!dfs(adj,visited,i))
            {
                return false;
            }
        }

        return visited.size() == numCourses;

    }
    
    public boolean dfs(Map<Integer,List<Integer>> adj, HashMap<Integer,Integer> visited, int node)
    {
        if(visited.containsKey(node) && visited.get(node) == 1)
        {
            return false;
        }
        if(visited.containsKey(node) && visited.get(node) == 2)
        {
            return true;
        }

        if(!adj.containsKey(node))
        {
            visited.put(node,2);
            return true;
        }

        visited.put(node,1);

        for(int next : adj.get(node))
        {
                if(!dfs(adj,visited,next))
                {
                    return false;
            }
        }

        visited.put(node,2);

        return true;
    }
  
}
