class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums)
        {
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        PriorityQueue<Integer> cur = new PriorityQueue<>(pq);
        for(int i = 0; i < k - 1; i ++)
        {
            cur.poll();
        }

        return cur.poll(); 
    }
}
