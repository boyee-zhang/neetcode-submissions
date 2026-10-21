class Solution {
    public int maxSubArray(int[] nums) {
        
       int maxSub = Integer.MIN_VALUE;
    int prefixSum = 0;
    int minPrefix = 0; // 注意：前缀和初始有一个 0（B范式！）

    for (int num : nums) {
        prefixSum += num;
        // 当前前缀和减去之前最小的前缀和，就是以当前结尾的最大子数组
        maxSub = Math.max(maxSub, prefixSum - minPrefix);
        // 更新最小前缀和
        minPrefix = Math.min(minPrefix, prefixSum);
    }
    return maxSub;
    }
}
