class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // nlogn order intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; ) {
            int j = i + 1;
            for (; j < intervals.length; j++) {   
                if (intervals[i][1] < intervals[j][0]) {
                    break;
                }
            }
            res.add(new int[]{intervals[i][0], Math.max(intervals[j - 1][1], intervals[i][1])});

            // 检查当前刚加入的区间与上一个已存入的区间是否需要 merge
            if ((res.size() - 1) > 0 && res.get(res.size() - 1)[0] <= res.get(res.size() - 2)[1]) {
                // 弹出最近加入的两个区间进行合并
                int[] curr = res.remove(res.size() - 1);
                int[] prev = res.remove(res.size() - 1);
                
                // 合并成一个新区间重新放回 res
                res.add(new int[]{prev[0], Math.max(prev[1], curr[1])});
            }
            i = j;
        }

        // List 转换为 int[][] 返回
        return res.toArray(new int[res.size()][]);
    }
}
