class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n; i ++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        List<int[]> arr = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            arr.add(new int[] {entry.getKey(),entry.getValue()});
        }

        arr.sort((a,b) -> b[1] - a[1]);

        int[] res = new int [k];

        for(int i = 0; i < k; i ++)
        {
            res[i] = arr.get(i)[0];
        }

        return res;

    }

}
