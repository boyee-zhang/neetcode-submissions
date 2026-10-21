class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // nlogn order intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] iv : intervals) {
        int n = res.size();
        if (n == 0 || res.get(n - 1)[1] < iv[0]) {
            res.add(new int[]{iv[0], iv[1]});
        } else {
            res.get(n - 1)[1] = Math.max(res.get(n - 1)[1], iv[1]);
        }
        }

        // List 转换为 int[][] 返回
        return res.toArray(new int[res.size()][]);
        
    }
}
