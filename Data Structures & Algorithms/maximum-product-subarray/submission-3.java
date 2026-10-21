class Solution {
    public int maxProduct(int[] nums) {
        int maxSofar = nums[0];
        System.out.println(maxSofar);
        System.out.println("");

        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < nums.length; i ++)
        {
            int n = nums[i];

            if(n < 0)
            {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], n * max);
            min = Math.min(nums[i], n * min);

            System.out.println("current max " + max);
            maxSofar = Math.max(maxSofar, max);
            System.out.println("current maxsofar " + maxSofar);

        }

        return maxSofar;
    }
}
