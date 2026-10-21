class Solution {
    class Container{

        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> b - a);

        public void add(int num)
        {
            max.add(num);

            if(max.size() > min.size() + 1)
            {
                min.add(max.poll());
            }
        }

        public Double getMid()
        {
            if(max.size() == min.size())
            {
                return (max.peek() + min.peek()) / 2.0;
            }
            else
            {
                return max.peek() / 1.0;
            }
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Container c = new Container();

        for(int num : nums1)
        {
            c.add(num);
        }
        
        for(int num : nums2)
        {
            c.add(num);
        }

        return c.getMid();
    }
}
