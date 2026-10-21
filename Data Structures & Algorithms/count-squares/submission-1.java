class CountSquares {
    
    HashMap<Integer,Map<Integer,Integer>> map = new HashMap<>();

    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x,new HashMap<>());
        Map<Integer, Integer> yCounts = map.get(x);
        yCounts.put(y,yCounts.getOrDefault(y,0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int count = 0;

        if(!map.containsKey(x)) return 0;

        Map<Integer,Integer> yPointsInSameX = map.get(x);

        for(int y1 : yPointsInSameX.keySet())
        {
            if(y1 == y)
            {
                continue;
            }

            int d = Math.abs(y1 - y);

            if(map.containsKey(x - d))
            {   
                //在这个地方 我想去看其他两个点的 y 的 k 得数，就卡住了，万一要是x - d 压根没有这个 y 和 y - d 呢？ 
                Map<Integer,Integer> leftSide = map.get(x - d);
                int countP3 = leftSide.getOrDefault(y,0);
                int countP4 = leftSide.getOrDefault(y1,0);

                count += countP3 * countP4  * yPointsInSameX.get(y1);
            }

            if(map.containsKey(x + d))
            {
                Map<Integer,Integer> rightSide = map.get(x + d);
                int countP3 = rightSide.getOrDefault(y,0);
                int countP4 = rightSide.getOrDefault(y1,0);

                count += countP3 * countP4 * yPointsInSameX.get(y1);
            }

        }

        return count;
    }
}
