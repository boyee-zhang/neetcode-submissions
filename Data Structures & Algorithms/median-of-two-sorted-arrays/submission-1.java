class Solution {
    // class Container{

    //     PriorityQueue<Integer> max = new PriorityQueue<>();
    //     PriorityQueue<Integer> min = new PriorityQueue<>((a,b) -> b - a);

    //     public void add(int num)
    //     {
    //         max.add(num);

    //         if(max.size() > min.size() + 1)
    //         {
    //             min.add(max.poll());
    //         }
    //     }

    //     public Double getMid()
    //     {
    //         if(max.size() == min.size())
    //         {
    //             return (max.peek() + min.peek()) / 2.0;
    //         }
    //         else
    //         {
    //             return max.peek() / 1.0;
    //         }
    //     }
    // }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Container c = new Container();

        // for(int num : nums1)
        // {
        //     c.add(num);
        // }
        
        // for(int num : nums2)
        // {
        //     c.add(num);
        // }

        // return c.getMid();

        int n = nums1.length;
        int m = nums2.length;

        int mid1 = 0;
        int mid2 = 0;

        int i = 0;
        int j = 0;

        for(int count = 0; count < (m + n) / 2 + 1; count ++)
        {   
            mid2 = mid1;

            if(i < n && j < m)
            {
                if(nums1[i] > nums2[j])
                {
                    mid1 = nums2[j];
                    j ++;
                }
                else
                {
                    mid1 = nums1[i];
                    i ++;
                }
            }
            else if(i < n)
            {
                mid1 = nums1[i];
                i ++;
            }
            else
            {
                mid1 = nums2[j];
                j ++;
            }
        }

        if((n + m) % 2 == 1)
        {
            return mid1 / 1.0;
        }
        else
        {
            return (mid1 + mid2) / 2.0;
        }
    }
}
