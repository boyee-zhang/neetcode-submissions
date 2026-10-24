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
        //build a graph

        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] pre : prerequisites)
        {
            int from = pre[1];
            int to = pre[0];

            graph.putIfAbsent(from,new ArrayList<>());
            graph.get(from).add(to);
        }


        // System.out.println(graph);
    
        for(int i = 0; i < numCourses; i ++)
        {
            if(dfs(i,graph,visited,new HashSet<>()))
            {
                return false;
            }
        }

        System.out.println("current visited size " + visited.size());
        return visited.size()!= numCourses ? false : true;
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
