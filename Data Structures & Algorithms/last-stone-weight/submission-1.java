class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int num : stones)
        {
            pq.add(num);
        }

        while(pq.size() >= 2)
        {
            int s1 = pq.poll();
            int s2 = pq.poll();

            System.out.printf("[Outer]current s1 : %d and s2 : %d \n",s1,s2);

            if(s1 != s2)
            {   
                System.out.printf("[Innter]current s1 : %d and s2 : %d \n",s1,s2);
                pq.add(Math.abs(s1 - s2));
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
