class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        final int OFFSET = 1000;

        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int freq = entry.getValue();

            if(buckets[freq] == null)
            {
                buckets[freq] = new LinkedList<>();
            }

            buckets[freq].add(entry.getKey() );
        }

        int[] res = new int[k];
        int index = 0;

        for(int i = nums.length; i >= 0; i --)
        {   
            if(k == 0)
            {
                break;
            }
            if(buckets[i] != null)
            {   
                // System.out.println("print freq " + i);
                for(int num : buckets[i])
                {
                    res[index ++] = num;
                    k --;
                }
                
            }
        }

        return res;
    }
}
