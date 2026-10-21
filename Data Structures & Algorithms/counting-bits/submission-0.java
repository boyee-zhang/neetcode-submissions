class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int [n + 1];

        for(int i = 0; i <= n; i ++)
        {
            int count = 0;

            int original = i;
            while(i != 0)
            {
                count += (i & 1);
                i >>>= 1;
            }
            i = original;
            res[i] = count;
        }

        return res;
    }
}
