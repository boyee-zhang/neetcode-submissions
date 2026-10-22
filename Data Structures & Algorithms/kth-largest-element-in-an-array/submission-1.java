class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        int slow = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums)
        {
            if(minHeap.size() <k)
            {
                minHeap.add(num);
            }
            else
            {
                minHeap.add(num);
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
