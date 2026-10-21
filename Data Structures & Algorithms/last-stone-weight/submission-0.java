class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int stone : stones)
        {
            pq.add(stone);
        }

        while(pq.size() != 1)
        {   
            if(pq.isEmpty())
            {
                return 0;
            }
            int prev = pq.poll();
            int next = pq.poll();
            
            if(prev == next)
            {
                continue;
            }
            else
            {
                pq.add(prev - next);
            }
        }   

        return pq.poll();
    }
}
